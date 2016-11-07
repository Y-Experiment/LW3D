/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package app

import com.jme3.math.FastMath

object Properties {
  object Camera {
    val invertVerticalAxis = true
    val trailingEnabled = false
    val minVerticalRotation = -1 * FastMath.PI / 2
    val defaultDistance = 100
    val minDistance = 10
    val maxDistance = 250
  }

}
