package io.github.mwttg.games.opengl.basic.utilities.buffer;

import io.github.mwttg.games.opengl.basic.utilities.cleanup.CleanUp;
import org.lwjgl.opengl.GL41;

public final class VertexArrayObject {

  private VertexArrayObject() {
  }

  public static int create(final float[] vertices, final float[] textureCoordinates) {
    final var id = GL41.glGenVertexArrays();
    CleanUp.addVertexArrayObjectId(id);
    GL41.glBindVertexArray(id);

    final var vertexVboId = VertexBufferObject.create(vertices);
    GL41.glBindBuffer(GL41.GL_ARRAY_BUFFER, vertexVboId);
    GL41.glVertexAttribPointer(0, 3, GL41.GL_FLOAT, false, 0, 0);

    final var uvVboId = VertexBufferObject.create(textureCoordinates);
    GL41.glBindBuffer(GL41.GL_ARRAY_BUFFER, uvVboId);
    GL41.glVertexAttribPointer(1, 2, GL41.GL_FLOAT, false, 0, 0);

    GL41.glEnableVertexAttribArray(0); // vertices
    GL41.glEnableVertexAttribArray(1); // texture coordinates

    return id;
  }
}
