package io.github.mwttg.games.opengl.basic.utilities.shader;

import java.util.List;
import java.util.stream.Collectors;
import org.lwjgl.opengl.GL41;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class Compile {

  private static final Logger LOG = LoggerFactory.getLogger(Compile.class);

  private Compile() {
  }

  static void apply(final int id, final List<String> sourceCode) {
    LOG.info("Compiling Shader with id='{}'", id);

    final var code = sourceCode
        .stream()
        .filter(line -> !line.equals(""))
        .collect(Collectors.joining("\n"));
    GL41.glShaderSource(id, code);
    GL41.glCompileShader(id);

    if (GL41.glGetShaderi(id, GL41.GL_COMPILE_STATUS) == GL41.GL_FALSE) {
      throw new RuntimeException(
          "Compile ShaderProgram failed: %s".formatted(GL41.glGetShaderInfoLog(id)));
    }
  }
}
