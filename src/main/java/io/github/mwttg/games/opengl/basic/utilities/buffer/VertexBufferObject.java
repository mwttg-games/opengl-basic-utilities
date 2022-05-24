package io.github.mwttg.games.opengl.basic.utilities.buffer;

import io.github.mwttg.games.opengl.basic.utilities.cleanup.CleanUp;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL41;

final class VertexBufferObject {

  private VertexBufferObject() {
  }

  static int create(final float[] data) {
    final var buffer = BufferUtils.createFloatBuffer(data.length);
    buffer.put(data);
    buffer.flip();

    final var id = GL41.glGenBuffers();
    CleanUp.addVertexBufferObjectId(id);
    GL41.glBindBuffer(GL41.GL_ARRAY_BUFFER, id);
    GL41.glBufferData(GL41.GL_ARRAY_BUFFER, buffer, GL41.GL_STATIC_DRAW);

    return id;
  }
}
