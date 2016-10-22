/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */
package states

import app.InputControls
import com.jme3.app.Application
import com.jme3.app.state.AppStateManager
import com.jme3.input.ChaseCamera
import com.jme3.input.controls.{KeyTrigger, MouseButtonTrigger}
import com.jme3.math.FastMath
import com.jme3.scene.Node
import nodes.model.{Earth, Lantern}

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

    camera = new ChaseCamera(app.getCamera, model, app.getInputManager)

    camera.setToggleRotationTrigger(
      new MouseButtonTrigger(InputControls.TOGGLE_ROTATION_MOUSE),
      new KeyTrigger(InputControls.TOGGLE_ROTATION_KEY))
    camera.setInvertVerticalAxis(true)
    camera.setTrailingEnabled(false)
    camera.setMinVerticalRotation(-1 * FastMath.PI / 2)
    camera.setDefaultDistance(300)
    camera.setMinDistance(5)
    camera.setMaxDistance(1000)
  }

  def onUpdate(node: Node, tpf: Float) = {

  }

  def onClean() = {

  }
}
