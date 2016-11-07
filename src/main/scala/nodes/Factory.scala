/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package nodes

import com.jme3.app.Application
import com.jme3.scene.Node

object Factory {
  var count = 0

  def apply[T <: Node](app: Application, id: String = ""): T = {
    if (id.isEmpty) {
      count += 1
      new T(app, classOf[T].getCanonicalName + "-" + count)
    } else new T(app, id)
  }
}

