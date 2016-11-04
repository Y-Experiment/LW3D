/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package states

import com.jme3.app.Application
import com.jme3.app.state.AppState
import com.jme3.app.state.AppStateManager
import com.jme3.renderer.RenderManager
import com.jme3.scene.Node

abstract class DefaultState(parentNode: Node) extends AppState {

  protected lazy val logger = java.util.logging.Logger.getLogger(getClass.getName)

  protected var initialized = false
  protected var enabled = false

  protected lazy val startNodes: Seq[Node] = Seq()

  protected var app: Application = _

  protected lazy val rootNode = new Node(getClass.getName)
  private var nodes = Map[String, Node]()

  def onInit(stateManager: AppStateManager, app: Application)
  def onUpdate(node: Node, tpf: Float)
  def onClean()
  def onAdd(node: Node)
  def onDel(node: Node)

  def add(node: Node) =
    if (!nodes.contains(node.getName)) {
      nodes = nodes.+((node.getName, node))
      onAdd(node)
    } else logger.warning("Trying to add duplicate node named: " + node.getName)

  def get(name: String): Node = nodes(name)

  def del(node: Node) = {
    nodes = nodes.filterKeys(!_.eq(node.getName))
    onDel(node)
  }

  def initialize(stateManager: AppStateManager, app: Application) = {
    this.app = app
    startNodes.foreach(add(_))
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

  def update(tpf: Float) = nodes.values.foreach(entity => onUpdate(entity, tpf))

  def render(renderManager: RenderManager) = {}

  def postRender() = {}

  def cleanup() = {
    onClean()
  }
}
