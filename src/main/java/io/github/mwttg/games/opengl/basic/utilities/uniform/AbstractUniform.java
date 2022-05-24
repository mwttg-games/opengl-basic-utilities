package io.github.mwttg.games.opengl.basic.utilities.uniform;

import java.nio.FloatBuffer;
import java.util.Map;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL41;

abstract class AbstractUniform {

  // Locations
  protected static final String MODEL_MATRIX = "modelMatrix";
  protected static final String VIEW_MATRIX = "viewMatrix";
  protected static final String PROJECTION_MATRIX = "projectionMatrix";
  protected static final String TEXTURE_SAMPLER0 = "textureSampler";

  private static final int CAPACITY = 16;
  private static final FloatBuffer MATRIX_BUFFER = BufferUtils.createFloatBuffer(CAPACITY);

  protected void activateTexture0(final int locationId, final int textureId) {
    GL41.glUniform1i(locationId, 0);
    GL41.glActiveTexture(GL41.GL_TEXTURE0);
    GL41.glBindTexture(GL41.GL_TEXTURE_2D, textureId);
  }

  protected void uploadMatrix(final int locationId, final Matrix4f matrix) {
    final var buffer = matrix.get(MATRIX_BUFFER);
    GL41.glUniformMatrix4fv(locationId, false, buffer);
  }

  protected Map.Entry<String, Integer> createLocation(final int shaderProgramId, final String name) {
    final var locationId = GL41.glGetUniformLocation(shaderProgramId, name);
    return Map.entry(name, locationId);
  }
}
