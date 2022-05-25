package io.github.mwttg.games.opengl.basic.utilities.shader;

public final class Shader {

  public static final int DEFAULT = defaultShader();

  private Shader() {
  }

  private static int defaultShader() {
    final var vertex = "/shader/vertex.glsl";
    final var fragment = "/shader/fragment.glsl";
    return ShaderProgram.createFromResource(vertex, fragment);
  }
}
