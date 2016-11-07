/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */
package states

import app.InputControls
import app.Properties
import com.jme3.app.Application
import com.jme3.app.state.AppStateManager
import com.jme3.input.ChaseCamera
import com.jme3.input.controls.MouseButtonTrigger
import com.jme3.input.controls.KeyTrigger
import com.jme3.math.FastMath
import com.jme3.scene.Node
import nodes.model.Earth
import nodes.model.Lantern

class SimulatorState(parentNode: Node) extends DefaultState(parentNode) {

  var camera: ChaseCamera = null

  def onAdd(node: Node) = {
    rootNode.attachChild(node)
  }

  def onDel(node: Node) = {

  }

  def onInit(stateManager: AppStateManager, app: Application) = {
    val model = new Lantern(app)
    model.setLocalTranslation(0, -800, 0)
//    model.rotate(FastMath.PI/(-2), FastMath.PI, 0)
    add(model)

    camera = new ChaseCamera(app.getCamera, rootNode, app.getInputManager)
    app.getCamera.setFrustumFar(100000f)
    camera.setToggleRotationTrigger(
      new MouseButtonTrigger(InputControls.TOGGLE_ROTATION_MOUSE),
      new KeyTrigger(InputControls.TOGGLE_ROTATION_KEY))
    camera.setInvertVerticalAxis(Properties.Camera.invertVerticalAxis)
    camera.setTrailingEnabled(Properties.Camera.trailingEnabled)
    camera.setMinVerticalRotation(Properties.Camera.minVerticalRotation)
    camera.setDefaultDistance(Properties.Camera.defaultDistance)
    camera.setMinDistance(Properties.Camera.minDistance)
    camera.setMaxDistance(Properties.Camera.maxDistance)
  }

  def onUpdate(node: Node, tpf: Float) = {

  }

  def onClean() = {

  }
}
