/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package states

import com.jme3.app.Application
import com.jme3.app.state.AppStateManager
import com.jme3.scene.Node

class DebugState(parentGuiNode: Node, parentRootNode: Node) extends DefaultState(parentRootNode) {

  def onInit(stateManager: AppStateManager, app: Application) = {

  }

  def onUpdate(node: Node, tpf: Float) = {

  }

  def onClean() = {

  }

  private lazy val guiNode: Node = new Node(getClass.getName)

  override def initialize(stateManager: AppStateManager, app: Application) = {
    super.initialize(stateManager, app)
  }

  override def stateAttached(stateManager: AppStateManager) = {
    parentGuiNode.attachChild(guiNode)
    super.stateAttached(stateManager)
  }

  override def stateDetached(stateManager: AppStateManager) = {
    parentGuiNode.detachChild(guiNode)
    super.stateDetached(stateManager)
  }
}
