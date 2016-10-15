/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package states

import com.jme3.app.Application
import com.jme3.app.state.{AppState, AppStateManager}
import com.jme3.renderer.RenderManager
import com.jme3.scene.Node

abstract class DefaultState(parentNode: Node) extends AppState {

  protected lazy val logger = java.util.logging.Logger.getLogger(getClass.getName)

  protected var initialized = false
  protected var enabled = false

  protected lazy val rootNode: Node = new Node(getClass.getName)

  def onInit(stateManager: AppStateManager, app: Application)

  def onUpdate(tpf: Float)

  def onClean()

  def initialize(stateManager: AppStateManager, app: Application) = {
    onInit(stateManager, app)

    initialized = true
  }

  def isInitialized: Boolean = initialized

  def isEnabled: Boolean = enabled

  def setEnabled(value: Boolean) = enabled = value

  def stateAttached(stateManager: AppStateManager) = {
    parentNode.attachChild(rootNode)
  }

  def stateDetached(stateManager: AppStateManager) = {
    parentNode.detachChild(rootNode)
  }

  def update(tpf: Float) = {
    onUpdate(tpf)
  }

  def render(renderManager: RenderManager) = {}

  def postRender() = {}

  def cleanup() = {
    onClean()
  }
}
