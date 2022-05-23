package io.github.mwttg.games.opengl.basic.utilities.gamewindow;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class InitializeKeyCallback {

  private static final Logger LOG = LoggerFactory.getLogger(InitializeKeyCallback.class);

  private InitializeKeyCallback() {
  }

  static void apply(final long gameWindowId) {
    LOG.info("Initialize Key callback");

    final GLFWKeyCallbackI callback =
        (long windowId, int key, int scancode, int action, int mods) -> {
          if (key == GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_RELEASE) {
            GLFW.glfwSetWindowShouldClose(windowId, true);
          }
        };
    GLFW.glfwSetKeyCallback(gameWindowId, callback);
  }
}
