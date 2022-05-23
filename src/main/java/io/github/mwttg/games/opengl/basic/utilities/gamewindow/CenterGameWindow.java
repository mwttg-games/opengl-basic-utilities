package io.github.mwttg.games.opengl.basic.utilities.gamewindow;

import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class CenterGameWindow {

  private static final Logger LOG = LoggerFactory.getLogger(CenterGameWindow.class);

  private CenterGameWindow() {
  }

  static void apply(final long gameWindowId, final OpenGlConfiguration configuration) {
    LOG.info("Center Game Window");

    final var width = configuration.width();
    final var height = configuration.height();
    final var videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
    if (videoMode == null) {
      throw new RuntimeException("No Video Mode was found.");
    }

    final var x = (videoMode.width() - width) / 2;
    final var y = (videoMode.height() - height) / 2;
    GLFW.glfwSetWindowPos(gameWindowId, x, y);
  }
}
