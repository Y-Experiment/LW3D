/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package nodes.gui

import com.jme3.app.Application
import com.jme3.font.BitmapText
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
            , size: Float = 64
            , color: ColorRGBA = ColorPalette.MAIN_LIGHT
            , position: Vector3f = Vector3f.ZERO
            , rotation: Quaternion = Quaternion.DIRECTION_Z
            , font: String = "Fonts/Default/Default.fnt"
           ) extends Node(id) {
  attachChild(
    new BitmapText(app.getAssetManager.loadFont(font), false) {
      setSize(size)
      setCullHint(CullHint.Never)
      setColor(color)
      setText(text)
      rotate(0,0, FastMath.PI)
      setLocalTranslation(position)
    })
}
