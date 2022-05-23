package io.github.mwttg.games.opengl.basic.utilities.gamewindow;

import io.github.mwttg.games.opengl.basic.utilities.cleanup.CleanUp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GameWindow {

  private static final Logger LOG = LoggerFactory.getLogger(GameWindow.class);

  private GameWindow() {
  }

  /**
   * Creates and configures an OpenGL game window, where the rendering is happening.
   *
   * @param configuration the OpenGL configuration values
   * @return the ID of the game window
   */
  public static long create(final OpenGlConfiguration configuration) {
    InitializeGlfw.apply();
    final var id = CreateGameWindow.apply(configuration);
    CleanUp.setGameWindowId(id);
    ConfigureGameWindow.apply(id, configuration);
    InitializeKeyCallback.apply(id);
    CenterGameWindow.apply(id, configuration);

    return id;
  }
}
