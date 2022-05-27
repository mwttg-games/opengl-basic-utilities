package io.github.mwttg.games.opengl.basic.utilities.geometry;

import org.apache.commons.lang3.ArrayUtils;

// @formatter:off
/**
 * <p>Wavefront OBJ file example</p>
 * # Blender v2.92.0 OBJ File: ''
 * # www.blender.org
 * o Plane
 * v 0.000000 0.000000 0.000000
 * v 1.000000 0.000000 0.000000
 * v 0.000000 1.000000 0.000000
 * v 1.000000 1.000000 0.000000
 * vt 1.000000 0.000000
 * vt 0.000000 1.000000
 * vt 0.000000 0.000000
 * vt 1.000000 1.000000
 * s off
 * f 2/1 3/2 1/3
 * f 2/1 4/4 3/2
 *
 * <p>OpenGL coordinates example</p>
 * The coordinates for the example plane from above would look like:
 *  v = 3 = (0.0, 1.0, 0.0)          v = 4 = (1.0, 1.0, 0.0)
 * vt = 2 = (0.0, 1.0)              vt = 4 = (1.0, 1.0)
 *               ------------------------
 *               | \                    |
 *               |    \                 |
 *               |       \              |
 *               |          \           |
 *               |              \       |
 *               |                 \    |
 *               |                    \ |
 *               ------------------------
 *  v = 1 = (0.0, 0.0, 0.0)          v = 2 = (1.0, 0.0, 0.0)
 * vt = 3 = (0.0, 0.0)              vt = 1 = (1.0, 0.0)
 */
// @formatter:on
public final class MeshFactory {

  private MeshFactory() {
  }

  /**
   * Creates a single plane (two triangles) with texture information (uv coordinates).
   *
   * @param width  the width of the plane
   * @param height the height of the plane
   * @return a {@link Mesh} including geometry and texture data
   */
  public static Mesh createSprite(final float width, final float height) {
    final var geometry = createGeometry(width, height);
    final var uvCoordinates = createUvCoordinates(0, 1);

    return new Mesh(geometry, uvCoordinates);
  }

  /**
   * Creates a Mesh containing several (size = animationSteps) planes. The planes are always the same plane (geometry), but
   * the UV coordinates are different. The UV coordinates split a texture (from left to right) in equal (animationSteps)
   * sprites.
   *
   * @param animationSteps the amount of (same) planes, equals the amount of sprites used for an animation
   * @param width          the width of the plane
   * @param height         the height of the plane
   * @return a {@link Mesh} including geometry and texture data
   */
  public static Mesh createAnimatedSprite(final int animationSteps, final float width, final float height) {
    var geometry = new float[] {};
    for (int index = 0; index < animationSteps; index++) {
      final var plane = createGeometry(width, height);
      geometry = ArrayUtils.addAll(geometry, plane);
    }

    var uvCoordinates = new float[] {};
    for (int index = 0; index < animationSteps; index++) {
      final var plane = createUvCoordinates(index, animationSteps);
      uvCoordinates = ArrayUtils.addAll(uvCoordinates, plane);
    }

    return new Mesh(geometry, uvCoordinates);
  }

  private static float[] createUvCoordinates(final int currentSpriteIndex, final int maxSprites) {
    final var spriteWidth = 1.0f / (float) maxSprites;
    final var left = spriteWidth * currentSpriteIndex;
    final var right = left + spriteWidth;

    return new float[] {
        right, 0.0f,
        left, 1.0f,
        left, 0.0f,
        right, 0.0f,
        right, 1.0f,
        left, 1.0f};
  }

  private static float[] createGeometry(final float width, final float height) {
    return new float[] {
        width, 0.0f, 0.0f,
        0.0f, height, 0.0f,
        0.0f, 0.0f, 0.0f,
        width, 0.0f, 0.0f,
        width, height, 0.0f,
        0.0f, height, 0.0f};
  }
}
