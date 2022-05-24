package io.github.mwttg.games.opengl.basic.utilities.shader;

import org.lwjgl.opengl.GL41;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class Link {

  private static final Logger LOG = LoggerFactory.getLogger(Link.class);

  private Link() {
  }

  static void apply(final int id) {
    LOG.info("Linking ShaderProgram with id='{}'", id);

    GL41.glLinkProgram(id);
    if (GL41.glGetProgrami(id, GL41.GL_LINK_STATUS) == GL41.GL_FALSE) {
      throw new RuntimeException(
          "Link ShaderProgram failed: %s".formatted(GL41.glGetProgramInfoLog(id)));
    }
  }
}
