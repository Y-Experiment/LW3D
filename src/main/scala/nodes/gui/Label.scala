/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package nodes.gui

import com.jme3.app.Application
import com.jme3.font.{BitmapFont, BitmapText, Rectangle}
import com.jme3.math.ColorRGBA
import com.jme3.math.FastMath
import com.jme3.math.Quaternion
import com.jme3.math.Vector3f
import com.jme3.scene.Node
import com.jme3.scene.Spatial.CullHint
import helpers.ColorPalette

class Label(app: Application
            , id: String = "label"
            , text: String = ""
            , fontSize: Float = 64
            , width: Float = 200
            , height: Float = 62
            , alignHorizontal: BitmapFont.Align = BitmapFont.Align.Left
            , alignVertical: BitmapFont.VAlign = BitmapFont.VAlign.Center
            , color: ColorRGBA = ColorPalette.MAIN_LIGHT
            , position: Vector3f = Vector3f.ZERO
            , rotation: Quaternion = new Quaternion().fromAngles(0, 0, FastMath.PI)
            , font: String = "Fonts/Default/Default.fnt"
           ) extends Node(id) {
  attachChild(
    new BitmapText(app.getAssetManager.loadFont(font), false) {
      setSize(fontSize)
      setCullHint(CullHint.Never)
      setColor(color)
      setText(text)
      rotate(rotation)
      setLocalTranslation(position)
      setBox(new Rectangle(0, 0, width, height))
      setAlignment(alignHorizontal)
      setVerticalAlignment(alignVertical)
    })
}
