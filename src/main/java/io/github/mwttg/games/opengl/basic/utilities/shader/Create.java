package io.github.mwttg.games.opengl.basic.utilities.shader;

import io.github.mwttg.games.opengl.basic.utilities.cleanup.CleanUp;
import org.lwjgl.opengl.GL41;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class Create {

  private static final Logger LOG = LoggerFactory.getLogger(Create.class);

  private Create() {
  }

  static int apply(final int type) {
    LOG.info("Creating Shader of type='{}'", type);

    final var id = GL41.glCreateShader(type);
    if (id == 0) {
      throw new RuntimeException("Can't create shader");
    }

    CleanUp.addShaderId(id);

    return id;
  }
}
