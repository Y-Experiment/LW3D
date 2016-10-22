/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package nodes.model

import com.jme3.app.Application
import com.jme3.material.Material
import com.jme3.material.RenderState.BlendMode
import com.jme3.math.ColorRGBA
import com.jme3.renderer.queue.RenderQueue
import com.jme3.scene.{Geometry, Node}
import com.jme3.scene.shape.Sphere

class Earth(app: Application) extends Node {
  val assetManager = app.getAssetManager()

  val sphere = new Geometry("", new Sphere(256, 256, 100)) {
    setMaterial(
      new Material(assetManager, "Shaders/PBRLighting.j3md") {
        setFloat("Metallic", 0.1f)
        setFloat("Roughness", 0.01f)
        setColor("BaseColor", ColorRGBA.White)
        setColor("Emissive", ColorRGBA.Yellow)
        setFloat("EmissivePower", 3f)
        setFloat("EmissiveIntensity", 0.25f)

        setTexture("BaseColorMap", assetManager.loadTexture("Earth/4096_earth.jpg"))
        setTexture("NormalMap", assetManager.loadTexture("Earth/4096_normal.jpg"))
        setTexture("ParallaxMap", assetManager.loadTexture("Earth/4096_bump.jpg"))
        setTexture("EmissiveMap", assetManager.loadTexture("Earth/4096_night_lights.jpg"))

//        setQueueBucket(RenderQueue.Bucket.Translucent)
      }
    )
  }

  val clouds = new Geometry("", new Sphere(256, 256, 100.9f)) {
    setMaterial(
      new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md") {
        setBoolean("UseMaterialColors", true)
        setFloat("Shininess", 8)
        setColor("Ambient", ColorRGBA.Black)
        setFloat("AlphaDiscardThreshold", 0.5882f)
        setColor("Diffuse", ColorRGBA.White) //new ColorRGBA(0.5882f, 0.5882f, 0.5882f, 1f))
        setTexture("DiffuseMap", assetManager.loadTexture("Earth/4096_clouds.jpg"))
        setTexture("AlphaMap", assetManager.loadTexture("Earth/4096_clouds.jpg"))
        setTexture("ParallaxMap", assetManager.loadTexture("Earth/4096_clouds.jpg"))
//        setQueueBucket(RenderQueue.Bucket.Transparent)
      }
    )
  }

  attachChild(sphere)
  attachChild(clouds)
}
