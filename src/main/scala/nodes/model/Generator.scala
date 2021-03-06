/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package nodes.model

import com.jme3.app.Application
import com.jme3.material.Material
import com.jme3.math.ColorRGBA
import com.jme3.scene.Node

class Generator(app: Application) extends Node("generator") {
  val assetManager = app.getAssetManager()

  val model = assetManager.loadModel("Generator/power-gen.j3o")

  model.setMaterial(
      new Material(assetManager, "Shaders/PBRLighting.j3md") {
        setFloat("Metallic", 0.85f)
        setFloat("Roughness", 0.65f)

        setColor("BaseColor", ColorRGBA.White)
        setColor("Emissive", ColorRGBA.White)
        setFloat("EmissivePower", 3f)
        setFloat("EmissiveIntensity", 2.7f)

        setTexture("BaseColorMap", assetManager.loadTexture("Generator/power-gen_color.png"))
        setTexture("SpecularMap", assetManager.loadTexture("Generator/power-gen_specular.png"))
        setTexture("ParallaxMap", assetManager.loadTexture("Generator/power-gen_normal.png"))
        setTexture("EmissiveMap", assetManager.loadTexture("Generator/power-gen_emmisive.png"))
      }
    )

  attachChild(model)
}
