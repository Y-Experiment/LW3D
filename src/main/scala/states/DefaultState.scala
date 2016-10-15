/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package states

import com.jme3.app.Application
import com.jme3.app.state.{AppState, AppStateManager}
import com.jme3.renderer.RenderManager
import com.jme3.scene.{Node, SceneGraphVisitor, Spatial}

abstract class DefaultState(parentNode: Node) extends AppState {

  protected lazy val logger = java.util.logging.Logger.getLogger(getClass.getName)

  protected var initialized = false
  protected var enabled = false

  private lazy val rootNode = new Node(getClass.getName)
  protected val rootNodeList = List[Node]()


  def onInit(stateManager: AppStateManager, app: Application)

  def onUpdate(node: Node, tpf: Float)

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

  def update(tpf: Float) = rootNodeList.foreach(onUpdate(_, tpf))

  def render(renderManager: RenderManager) = {}

  def postRender() = {}

  def cleanup() = {
    onClean()
  }
}
