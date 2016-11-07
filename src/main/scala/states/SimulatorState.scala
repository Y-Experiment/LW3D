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
import nodes.Factory
import nodes.model.Earth
import nodes.model.Generator

class SimulatorState(parentNode: Node) extends DefaultState(parentNode) {

  var camera: ChaseCamera = _

  def onAdd(node: Node) = {
    rootNode.attachChild(node)
  }

  def onDel(node: Node) = {

  }

  def onInit(stateManager: AppStateManager, app: Application) = {
    val model = Factory[Earth](app)
    model.setLocalTranslation(-300, -300, 300)
    model.rotate(FastMath.PI/(-2), FastMath.PI, 0)
    add(model)

    val generator = Factory[Generator](app)
    generator.setLocalTranslation(0, 0, 0)

    add(generator)

    app.getCamera.setFrustumFar(100000f)

    camera = new ChaseCamera(app.getCamera, rootNode, app.getInputManager) {
      setToggleRotationTrigger(
        new MouseButtonTrigger(InputControls.TOGGLE_ROTATION_MOUSE),
        new KeyTrigger(InputControls.TOGGLE_ROTATION_KEY))
      setInvertVerticalAxis(Properties.Camera.invertVerticalAxis)
      setTrailingEnabled(Properties.Camera.trailingEnabled)
      setMinVerticalRotation(Properties.Camera.minVerticalRotation)
      setDefaultDistance(Properties.Camera.defaultDistance)
      setMinDistance(Properties.Camera.minDistance)
      setMaxDistance(Properties.Camera.maxDistance)
    }
  }

  def onUpdate(node: Node, tpf: Float) = {

  }

  def onClean() = {

  }
}
