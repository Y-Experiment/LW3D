/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package states

import com.jme3.app.Application
import com.jme3.app.state.AppStateManager
import com.jme3.font.BitmapFont
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
      new gui.Button(app
        , id = "BtnRest"
        , text = "Reset"
        , position = new Vector3f(0, app.getViewPort.getCamera.getHeight * 10/12, -2f)
      ) {
        override def onClick = {

        }
      },
      new gui.Label(app
        , text = "LightWeight 3D"
        , position = new Vector3f(0, app.getViewPort.getCamera.getHeight * 11/12, -2f)
        , width = app.getViewPort.getCamera.getWidth
        , height = app.getViewPort.getCamera.getHeight / 12
        , alignHorizontal = BitmapFont.Align.Center
      )
    )
  }

  def onAdd(node: Node): Unit = {
    rootNode.attachChild(node)
  }

  def onDel(node: Node): Unit = {

  }
  def onInit(stateManager: AppStateManager, app: Application): Unit = {

  }

  def onUpdate(node: Node, tpf: Float): Unit = {

  }

  def onClean(): Unit = {

  }

}
