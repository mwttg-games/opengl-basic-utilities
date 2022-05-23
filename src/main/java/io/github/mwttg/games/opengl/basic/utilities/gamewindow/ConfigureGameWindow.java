package io.github.mwttg.games.opengl.basic.utilities.gamewindow;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL41;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class ConfigureGameWindow {

  private static final Logger LOG = LoggerFactory.getLogger(ConfigureGameWindow.class);

  private ConfigureGameWindow() {
  }

  static void apply(final long gameWindowId, final OpenGlConfiguration configuration) {
    LOG.info("Configure Game Window");

    final var vsync = configuration.vsync() ? 1 : 0;
    final var isWireframe = configuration.wireframe();
    final var red = configuration.clearColorRed();
    final var green = configuration.clearColorGreen();
    final var blue = configuration.clearColorBlue();

    GLFW.glfwMakeContextCurrent(gameWindowId);
    GL.createCapabilities();
    GL41.glClearColor(red, green, blue, 1.0f);
    GLFW.glfwSwapInterval(vsync);
    GLFW.glfwShowWindow(gameWindowId);
    GL41.glEnable(GL41.GL_DEPTH_TEST);
    GL41.glEnable(GL41.GL_BLEND);
    GL41.glBlendFunc(GL41.GL_SRC_ALPHA, GL41.GL_ONE_MINUS_SRC_ALPHA);
    GL41.glEnable(GL41.GL_CULL_FACE);
    GL41.glCullFace(GL41.GL_BACK);

    if (isWireframe) {
      GL41.glPolygonMode(GL41.GL_FRONT_AND_BACK, GL41.GL_LINE);
    }
  }
}
