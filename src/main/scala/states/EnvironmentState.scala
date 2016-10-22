/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package states

import com.jme3.app.Application
import com.jme3.app.state.AppStateManager
import com.jme3.asset.AssetManager
import com.jme3.light.{AmbientLight, DirectionalLight}
import com.jme3.math.{ColorRGBA, Vector3f}
import com.jme3.scene.Node
import com.jme3.util.SkyFactory

class EnvironmentState(parentNode: Node) extends DefaultState(parentNode) {

  val ambientLight = new AmbientLight()
  val directionalLight = new DirectionalLight(Vector3f.UNIT_Z, ColorRGBA.White)
  var lightAdded = false

  def onAdd(node: Node) = {

  }

  def onDel(node: Node) = {

  }
  def onInit(stateManager: AppStateManager, app: Application) = {
    loadSkybox("LW3D", app.getAssetManager)
    setAmbientColor(ColorRGBA.White)
    parentNode.addLight(directionalLight)
    app.getViewPort.setBackgroundColor(ColorRGBA.Green)
  }

  def onUpdate(node: Node, tpf: Float) = {

  }

  def onClean() = {

  }

  def setAmbientColor(color: ColorRGBA) = {
    ambientLight.setColor(color)
    if (!lightAdded) {
      parentNode.addLight(ambientLight)
      lightAdded = true
    }
  }

  def loadSkybox(name: String, assetManager: AssetManager) = {
    rootNode.attachChild(SkyFactory.createSky(assetManager,
      assetManager.loadTexture("Skybox/" + name + "_left2.png"),
      assetManager.loadTexture("Skybox/" + name + "_right1.png"),
      assetManager.loadTexture("Skybox/" + name + "_front5.png"),
      assetManager.loadTexture("Skybox/" + name + "_back6.png"),
      assetManager.loadTexture("Skybox/" + name + "_top3.png"),
      assetManager.loadTexture("Skybox/" + name + "_bottom4.png")
    ))
  }
}
