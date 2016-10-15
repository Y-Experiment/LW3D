/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package states

import com.jme3.app.Application
import com.jme3.app.state.AppStateManager
import com.jme3.math.Vector3f
import com.jme3.scene.Node
import nodes.gui._

class GuiState(parentNode: Node) extends DefaultState(parentNode) {

  override protected lazy val startNodes: Seq[Node] = {
    Seq(
      new Panel(app
        , width = app.getViewPort.getCamera.getWidth / 2
        , height = app.getViewPort.getCamera.getHeight / 2
        , position = new Vector3f(app.getViewPort.getCamera.getWidth * .25f, app.getViewPort.getCamera.getHeight * .25f, -2f)
      ),
      new Button(app) {
        override def onClick = {

        }
      },
      new Label(app
        , text = "Hi there :)"
        , position = new Vector3f(app.getViewPort.getCamera.getWidth * .425f, app.getViewPort.getCamera.getHeight * .525f, -2f)
      )
    )
  }

  def onAdd(node: Node) = {
    parentNode.attachChild(node)
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
