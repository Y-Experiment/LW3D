/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package nodes.model

import com.jme3.app.Application
import com.jme3.material.Material
import com.jme3.material.RenderState.BlendMode
import com.jme3.math.ColorRGBA
import com.jme3.renderer.queue.RenderQueue
import com.jme3.scene.shape.Sphere
import com.jme3.scene.{Geometry, Node}

class Lantern(app: Application) extends Node {
  val assetManager = app.getAssetManager()

  val lantern = assetManager.loadModel("Lantern/Latern_Rusted_final.j3o").asInstanceOf[Node]
  lantern.setMaterial(
      new Material(assetManager, "Shaders/PBRLighting.j3md") {
        setFloat("Metallic", .5f)
        setFloat("Roughness", 0.05f)
//        setFloat("AlphaDiscardThreshold", 0.1f)
        setColor("BaseColor", ColorRGBA.White)
//        setColor("Emissive", ColorRGBA.Yellow)
//        setFloat("EmissivePower", 3f)
//        setFloat("EmissiveIntensity", 0.25f)

        setTexture("BaseColorMap", assetManager.loadTexture("Lantern/Base_Color.jpg"))
        setTexture("NormalMap", assetManager.loadTexture("Lantern/Normal.jpg"))
        setTexture("RoughnessMap", assetManager.loadTexture("Lantern/Normal.jpg"))
        setTexture("SpecularMap", assetManager.loadTexture("Lantern/Specular.jpg"))
        setTexture("ParallaxMap", assetManager.loadTexture("Lantern/Height.jpg"))
        setTexture("MetallicMap", assetManager.loadTexture("Lantern/Glosiness.jpg"))

        //        setTexture("MetalicMap", assetManager.loadTexture("Lantern/Glosiness.jpg"))
        getAdditionalRenderState.setBlendMode(BlendMode.Alpha)
        setQueueBucket(RenderQueue.Bucket.Transparent)
      }
    )
  lantern.getChild("Latern_Rusted_final-geom-6").setMaterial(
    new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md") {
      setColor("Color", ColorRGBA.BlackNoAlpha)
      getAdditionalRenderState.setBlendMode(BlendMode.Alpha)
      setQueueBucket(RenderQueue.Bucket.Transparent)
    }
  )


  attachChild(lantern)
}
