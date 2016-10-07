/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package gui

import com.jme3.app.Application
import com.jme3.app.state.{AppState, AppStateManager}
import com.jme3.renderer.RenderManager
import com.jme3.scene.Node

abstract class DefaultState(parentNode: Node) extends AppState {

  protected var initialized = false
  protected var enabled = false

  protected var rootNode: Node = _

  def onInit(stateManager: AppStateManager, app: Application)

  def onUpdate(tpf: Float)

  def onClean()

  def initialize(stateManager: AppStateManager, app: Application) = {
    rootNode = new Node(getClass.getName)
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

  def update(tpf: Float) = if (enabled) {
    onUpdate(tpf)
  }

  def render(renderManager: RenderManager) = {}

  def postRender() = {}

  def cleanup() = {
    onClean()
  }
}
