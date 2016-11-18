/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package nodes.gui

import com.jme3.app.Application
import com.jme3.font.BitmapFont
import com.jme3.material.Material
import com.jme3.material.RenderState.BlendMode
import com.jme3.math.{ColorRGBA, FastMath, Quaternion, Vector3f}
import com.jme3.scene.Spatial.CullHint
import com.jme3.scene.shape.Quad
import com.jme3.scene.{Geometry, Node}
import helpers.ColorPalette

abstract class Button(app: Application
             , id: String = "button"
             , text: String = ""
             , width: Float = 200
             , height: Float = 62
             , position: Vector3f = Vector3f.ZERO.clone
             , color: ColorRGBA = ColorPalette.LOW_COLOR
             , rotation: Quaternion = new Quaternion().fromAngles(0, 0, FastMath.PI)
             , font: String = "Fonts/Default/Default.fnt"
             , fontColor: ColorRGBA = ColorPalette.HIGH_DARK
             , fontSize: Float = 24) extends Node(id) {

  def onClick(): Unit

  val background = new Geometry("QuadOf"+id, new Quad(width, height)) {
    setMaterial(
      new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md") {
        setColor("Color", color)
        getAdditionalRenderState().setBlendMode(BlendMode.Alpha)
      })
    setLocalTranslation(position.add(0f,0f,-1f))
    setCullHint(CullHint.Never)
  }

  attachChild(background)
  attachChild(new Label(app
    , id = id+"BtnLabel"
    , text = text
    , fontSize = fontSize
    , color = fontColor
    , position = position.add(0, height, 0)
    , rotation = rotation
    , alignHorizontal = BitmapFont.Align.Center
    , alignVertical = BitmapFont.VAlign.Center
  , font = font
  ))
}
