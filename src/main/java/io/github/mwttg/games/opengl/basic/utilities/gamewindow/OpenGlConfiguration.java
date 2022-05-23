package io.github.mwttg.games.opengl.basic.utilities.gamewindow;

public record OpenGlConfiguration(int majorVersion,
                                  int minorVersion,
                                  String title,
                                  int width,
                                  int height,
                                  boolean fullscreen,
                                  boolean vsync,
                                  boolean wireframe,
                                  float clearColorRed,
                                  float clearColorGreen,
                                  float clearColorBlue,
                                  float nearPlane,
                                  float farPlane) {
  public String prettyPrint() {
    return """
            + OpenGL configuration
                OpenGl version .................. %s.%s
                window title .................... %s
                resolution ...................... %sx%s
                fullscreen ...................... %s
                v-sync .......................... %s
                wireframe ....................... %s
                clear-color (r, g, b) ........... (%s, %s, %s, 1.0)
                near plane ...................... %s
                far plane ....................... %s
        """.formatted(
        majorVersion,
        minorVersion,
        title,
        width,
        height,
        fullscreen,
        vsync,
        wireframe,
        clearColorRed,
        clearColorGreen,
        clearColorBlue,
        nearPlane,
        farPlane);
  }
}