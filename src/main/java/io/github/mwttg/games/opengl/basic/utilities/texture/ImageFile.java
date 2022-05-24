package io.github.mwttg.games.opengl.basic.utilities.texture;

import java.io.File;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class ImageFile {

  private static final Logger LOG = LoggerFactory.getLogger(ImageFile.class);

  private ImageFile() {
  }

  public static Image read(final String filename) {
    LOG.info("Reading image file: '{}'", filename);

    final var stack = MemoryStack.stackPush();
    final var widthBuffer = stack.mallocInt(1);
    final var heightBuffer = stack.mallocInt(1);
    final var colorBuffer = stack.mallocInt(1);

    final var file = new File(filename).getAbsolutePath();
    STBImage.stbi_set_flip_vertically_on_load(true);
    final var pixels = STBImage.stbi_load(file, widthBuffer, heightBuffer, colorBuffer, 4);
    if (pixels == null) {
      throw new RuntimeException(
          "Error reading Image file '%s'. Reason was: %s".formatted(filename,
              STBImage.stbi_failure_reason()));
    }

    return new Image(widthBuffer.get(), heightBuffer.get(), pixels);
  }
}
