package io.github.mwttg.games.opengl.basic.utilities.shader;

import io.github.mwttg.games.basic.utilities.files.TextFile;
import io.github.mwttg.games.opengl.basic.utilities.cleanup.CleanUp;
import java.util.List;
import org.lwjgl.opengl.GL41;

public final class ShaderProgram {

  private ShaderProgram() {
  }

  public static int createFrom(final String vertexShaderFile, final String fragmentShaderFile) {
    final var vertexShaderCode = TextFile.readFrom(vertexShaderFile);
    final var fragmentShaderCode = TextFile.readFrom(fragmentShaderFile);
    return create(vertexShaderCode, fragmentShaderCode);
  }

  public static int createFromResource(final String vertexShaderFile, final String fragmentShaderFile) {
    final var vertexShaderCode = TextFile.readFromResource(vertexShaderFile);
    final var fragmentShaderCode = TextFile.readFromResource(fragmentShaderFile);
    return create(vertexShaderCode, fragmentShaderCode);
  }

  private static int create(final List<String> vertexShaderCode, final List<String> fragmentShaderCode) {
    final var shaderProgramId = GL41.glCreateProgram();
    CleanUp.addShaderProgramId(shaderProgramId);

    final var vertexShaderId = Create.apply(GL41.GL_VERTEX_SHADER);
    Compile.apply(vertexShaderId, vertexShaderCode);

    final var fragmentShaderId = Create.apply(GL41.GL_FRAGMENT_SHADER);
    Compile.apply(fragmentShaderId, fragmentShaderCode);

    GL41.glAttachShader(shaderProgramId, vertexShaderId);
    GL41.glAttachShader(shaderProgramId, fragmentShaderId);

    Link.apply(shaderProgramId);

    GL41.glDetachShader(shaderProgramId, vertexShaderId);
    GL41.glDetachShader(shaderProgramId, fragmentShaderId);

    return shaderProgramId;
  }


  public static void validate(final int shaderProgramId) {
    Validate.apply(shaderProgramId);
  }
}
