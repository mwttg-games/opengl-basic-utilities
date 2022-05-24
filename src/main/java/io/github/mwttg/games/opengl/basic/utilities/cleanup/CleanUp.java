package io.github.mwttg.games.opengl.basic.utilities.cleanup;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL41;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CleanUp {

  private static final Logger LOG = LoggerFactory.getLogger(CleanUp.class);

  private static long gameWindowId;
  private static final List<Integer> vertexBufferObjectIds = new ArrayList<>();
  private static final List<Integer> vertexArrayObjectIds = new ArrayList<>();

  public static void setGameWindowId(final Long id) {
    gameWindowId = id;
  }

  public static void addVertexBufferObjectId(final int id) {
    vertexBufferObjectIds.add(id);
  }

  public static void addVertexArrayObjectId(final int id) {
    vertexArrayObjectIds.add(id);
  }

  public static void purge() {
    LOG.info("Start clean up process");
    LOG.debug("Remove VertexArrayObjects");
    vertexArrayObjectIds.forEach(GL41::glDeleteVertexArrays);
    LOG.debug("Remove VertexBufferObjects");
    vertexBufferObjectIds.forEach(GL41::glDeleteBuffers);
    LOG.debug("Remove GameWindow");
    cleanUpGameWindow();
  }

  private static void cleanUpGameWindow() {
    GLFW.glfwDestroyWindow(gameWindowId);
    GLFW.glfwTerminate();
  }
}
