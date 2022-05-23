package io.github.mwttg.games.opengl.basic.utilities.gamewindow;

import static org.lwjgl.system.MemoryUtil.NULL;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL41;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class CreateGameWindow {

  private static final Logger LOG = LoggerFactory.getLogger(CreateGameWindow.class);

  private CreateGameWindow() {
  }

  static long apply(final OpenGlConfiguration configuration) {
    LOG.info("Create Game Window");

    final var openGlMajorVersion = configuration.majorVersion();
    final var openGlMinorVersion = configuration.minorVersion();
    final var title = configuration.title();
    final var width = configuration.width();
    final var height = configuration.height();

    GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GL41.GL_TRUE);
    GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GL41.GL_TRUE);
    GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, openGlMajorVersion);
    GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, openGlMinorVersion);
    GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GL41.GL_TRUE);
    GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);

    final var monitor = GLFW.glfwGetPrimaryMonitor();
    final var id = GLFW.glfwCreateWindow(width, height, title, monitor, NULL);
    if (id == NULL) {
      throw new RuntimeException("Unable to create Game Window.");
    }

    return id;
  }
}
