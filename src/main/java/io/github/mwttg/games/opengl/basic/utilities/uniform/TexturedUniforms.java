package io.github.mwttg.games.opengl.basic.utilities.uniform;

import java.util.Map;
import org.joml.Matrix4f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TexturedUniforms extends AbstractUniform {

  private static final Logger LOG = LoggerFactory.getLogger(TexturedUniforms.class);

  private final Map<String, Integer> locations;

  public TexturedUniforms(final int shaderProgramId) {
    LOG.info("Creating Uniforms for ShaderProgram with id = '{}'", shaderProgramId);
    this.locations = initializeLocations(shaderProgramId);
  }

  public void upload(final Matrix4f model, final Matrix4f view, final Matrix4f projection, final int textureId) {
    uploadMatrix(locations.get(MODEL_MATRIX), model);
    uploadMatrix(locations.get(VIEW_MATRIX), view);
    uploadMatrix(locations.get(PROJECTION_MATRIX), projection);
    activateTexture0(locations.get(TEXTURE_SAMPLER0), textureId);
  }

  private Map<String, Integer> initializeLocations(int shaderProgramId) {
    return Map.ofEntries(createLocation(shaderProgramId, MODEL_MATRIX), createLocation(shaderProgramId, VIEW_MATRIX),
        createLocation(shaderProgramId, PROJECTION_MATRIX), createLocation(shaderProgramId, TEXTURE_SAMPLER0));
  }
}
