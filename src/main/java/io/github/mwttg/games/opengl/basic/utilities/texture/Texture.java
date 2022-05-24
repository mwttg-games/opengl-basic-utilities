package io.github.mwttg.games.opengl.basic.utilities.texture;

public final class Texture {

  private Texture() {
  }

  public static int create(final String filename) {
    final var image = ImageFile.read(filename);
    return Create.apply(image);
  }
}
