package io.github.mwttg.games.opengl.basic.utilities.gamewindow;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class InitializeGlfw {

  private static final Logger LOG = LoggerFactory.getLogger(InitializeGlfw.class);

  private InitializeGlfw() {
  }

  static void apply() {
    LOG.info("Initialize GLFW");

    GLFWErrorCallback.createPrint(System.err).set();
    if (!GLFW.glfwInit()) {
      throw new RuntimeException("GLFW wasn't initialized correctly.");
    }
  }
}
