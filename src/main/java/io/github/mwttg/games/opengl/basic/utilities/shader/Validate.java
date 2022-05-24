package io.github.mwttg.games.opengl.basic.utilities.shader;

import org.lwjgl.opengl.GL41;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class Validate {

  private static final Logger LOG = LoggerFactory.getLogger(Validate.class);

  private Validate() {
  }

  static void apply(final int id) {
    LOG.info("Validating ShaderProgram with id='{}'", id);

    GL41.glValidateProgram(id);
    if (GL41.glGetProgrami(id, GL41.GL_VALIDATE_STATUS) == GL41.GL_FALSE) {
      throw new RuntimeException(
          "Validate ShaderProgram failed: %s".formatted(GL41.glGetProgramInfoLog(id)));
    }
  }
}
