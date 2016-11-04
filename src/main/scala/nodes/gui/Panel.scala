/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package nodes.gui

import com.jme3.app.Application
import com.jme3.material.Material
import com.jme3.material.RenderState.BlendMode
import com.jme3.math.ColorRGBA
import com.jme3.math.Vector3f
import com.jme3.scene.Spatial.CullHint
import com.jme3.scene.shape.Quad
import com.jme3.scene.{Geometry, Node}
import helpers.ColorPalette

class Panel(app: Application,
            name: String = "panel",
            width: Float = 100,
            height: Float = 100,
            position: Vector3f = Vector3f.ZERO,
            color: ColorRGBA = ColorPalette.SECOND_DARK.mult(new ColorRGBA(1,1,1,0.5f))) extends Node(name) {
  attachChild(
    new Geometry("QuadOf"+getName, new Quad(width, height)) {
      setMaterial(
        new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md") {
          setColor("Color", color)
          getAdditionalRenderState().setBlendMode(BlendMode.Alpha)
        })
      setLocalTranslation(position)
      setCullHint(CullHint.Never)
    })
}
