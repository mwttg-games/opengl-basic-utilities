package io.github.mwttg.games.opengl.basic.utilities.geometry;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class MeshFactoryTest {

  @Test
  public void testCreateSprite_example1() {
    final var actual = MeshFactory.createSprite(1.0f, 2.0f);
    assertThat(actual.geometry())
        .containsExactly(
            1.0f, 0.0f, 0.0f,
            0.0f, 2.0f, 0.0f,
            0.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 2.0f, 0.0f,
            0.0f, 2.0f, 0.0f);
    assertThat(actual.textureCoordinates())
        .containsExactly(
            1.0f, 0.0f,
            0.0f, 1.0f,
            0.0f, 0.0f,
            1.0f, 0.0f,
            1.0f, 1.0f,
            0.0f, 1.0f);
  }

  @Test
  public void testCreateSprite_example2() {
    final var actual = MeshFactory.createSprite(4.0f, 3.0f);
    assertThat(actual.geometry())
        .containsExactly(
            4.0f, 0.0f, 0.0f,
            0.0f, 3.0f, 0.0f,
            0.0f, 0.0f, 0.0f,
            4.0f, 0.0f, 0.0f,
            4.0f, 3.0f, 0.0f,
            0.0f, 3.0f, 0.0f);
    assertThat(actual.textureCoordinates())
        .containsExactly(
            1.0f, 0.0f,
            0.0f, 1.0f,
            0.0f, 0.0f,
            1.0f, 0.0f,
            1.0f, 1.0f,
            0.0f, 1.0f);
  }

  @Test
  public void testCreateAnimatedSprite_onlyOneAnimationStep() {
    final var x = MeshFactory.createAnimatedSprite(1, 1.0f, 1.0f);
    final var y = MeshFactory.createSprite(1.0f, 1.0f);
    assertThat(x.geometry()).containsExactly(y.geometry());
    assertThat(x.textureCoordinates()).containsExactly(y.textureCoordinates());
  }

  @Test
  public void testCreateAnimatedSprite_twoAnimationSteps() {
    final var actual = MeshFactory.createAnimatedSprite(2, 1.0f, 2.0f);
    assertThat(actual.geometry())
        .containsExactly(
            // first plane
            1.0f, 0.0f, 0.0f,
            0.0f, 2.0f, 0.0f,
            0.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 2.0f, 0.0f,
            0.0f, 2.0f, 0.0f,
            // second plane
            1.0f, 0.0f, 0.0f,
            0.0f, 2.0f, 0.0f,
            0.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 2.0f, 0.0f,
            0.0f, 2.0f, 0.0f);
    assertThat(actual.textureCoordinates())
        .containsExactly(
            // first plane
            0.5f, 0.0f,
            0.0f, 1.0f,
            0.0f, 0.0f,
            0.5f, 0.0f,
            0.5f, 1.0f,
            0.0f, 1.0f,
            // second plane
            1.0f, 0.0f,
            0.5f, 1.0f,
            0.5f, 0.0f,
            1.0f, 0.0f,
            1.0f, 1.0f,
            0.5f, 1.0f);
  }
}