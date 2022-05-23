package io.github.mwttg.games.opengl.basic.utilities.cleanup;

import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CleanUp {

  private static final Logger LOG = LoggerFactory.getLogger(CleanUp.class);

  private static long gameWindowId;

  public static void setGameWindowId(final Long id) {
    gameWindowId = id;
  }

  public static void purge() {
    LOG.info("Start clean up process");
    LOG.debug("Remove GameWindow");
    cleanUpGameWindow();
  }

  private static void cleanUpGameWindow() {
    GLFW.glfwDestroyWindow(gameWindowId);
    GLFW.glfwTerminate();
  }
}
