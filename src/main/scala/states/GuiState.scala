/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package states

import com.jme3.app.Application
import com.jme3.app.state.AppStateManager
import com.jme3.math.Vector3f
import com.jme3.scene.Node
import nodes.gui

class GuiState(parentNode: Node) extends DefaultState(parentNode) {

  override protected lazy val startNodes: Seq[Node] = {
    Seq(
      new gui.Panel(app
        , width = app.getViewPort.getCamera.getWidth
        , height = app.getViewPort.getCamera.getHeight / 12
        , position = new Vector3f(0, app.getViewPort.getCamera.getHeight * 11/12, -2f)
      ),
      new gui.Button(app) {
        override def onClick = {

        }
      },
      new gui.Label(app
        , text = "Hello world :)"
        , position = new Vector3f(app.getViewPort.getCamera.getWidth * .425f, app.getViewPort.getCamera.getHeight, -2f)
      )
    )
  }

  def onAdd(node: Node) = {
    rootNode.attachChild(node)
  }

  def onDel(node: Node) = {

  }
  def onInit(stateManager: AppStateManager, app: Application) = {

  }

  def onUpdate(node: Node, tpf: Float) = {

  }

  def onClean() = {

  }

}
