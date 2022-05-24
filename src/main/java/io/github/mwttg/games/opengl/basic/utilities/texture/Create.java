package io.github.mwttg.games.opengl.basic.utilities.texture;

import io.github.mwttg.games.opengl.basic.utilities.cleanup.CleanUp;
import org.lwjgl.opengl.GL41;
import org.lwjgl.stb.STBImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class Create {

  private static final Logger LOG = LoggerFactory.getLogger(Create.class);

  private Create() {
  }

  static int apply(final Image data) {
    LOG.info("Creating Texture {}x{}", data.width(), data.height());

    final var id = GL41.glGenTextures();
    CleanUp.addTextureId(id);

    GL41.glBindTexture(GL41.GL_TEXTURE_2D, id);
    GL41.glPixelStorei(GL41.GL_UNPACK_ALIGNMENT, 1);
    GL41.glTexImage2D(GL41.GL_TEXTURE_2D, 0, GL41.GL_RGBA, data.width(), data.height(), 0, GL41.GL_RGBA, GL41.GL_UNSIGNED_BYTE,
        data.pixels());
    // NEAREST Filtering instead of LINEAR for sharp edges
    GL41.glTexParameteri(GL41.GL_TEXTURE_2D, GL41.GL_TEXTURE_MIN_FILTER, GL41.GL_NEAREST_MIPMAP_NEAREST);
    GL41.glTexParameteri(GL41.GL_TEXTURE_2D, GL41.GL_TEXTURE_MAG_FILTER, GL41.GL_NEAREST);
    GL41.glGenerateMipmap(GL41.GL_TEXTURE_2D);
    STBImage.stbi_image_free(data.pixels());

    return id;
  }
}
