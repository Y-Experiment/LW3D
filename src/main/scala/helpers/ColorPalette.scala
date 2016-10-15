/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package helpers

import com.jme3.math.ColorRGBA

object ColorPalette {
  // http://paletton.com/#uid=72R0X0kllllaFw0g0qFqFg0w0aF
  lazy val MAIN_COLOR = new ColorRGBA(.173f, .518f, .216f, 1f)
  lazy val MAIN_BRIGHT = new ColorRGBA(.518f, .776f, .549f, 1f)
  lazy val MAIN_DARK = new ColorRGBA(0f, .259f, .031f, 1f)

  lazy val SECOND_COLOR = new ColorRGBA(.184f, .255f, .447f, 1f)
  lazy val SECOND_LIGHT = new ColorRGBA(.475f, .525f, .675f, 1f)
  lazy val SECOND_DARK = new ColorRGBA(.024f, .078f, .224f, 1f)

  lazy val HIGH_COLOR = new ColorRGBA(.667f, .247f, .224f, .1f)
  lazy val HIGH_LIGHT = new ColorRGBA(1f, .682f, .667f, 1f)
  lazy val HIGH_DARK = new ColorRGBA(.333f, .016f, 0f, 1f)

  lazy val BACK_COLOR = new ColorRGBA(.667f, .525f, .224f, 1f)
  lazy val BACK_LIGHT = new ColorRGBA(1f, .894f, .667f, 1f)
  lazy val BACK_DARK = new ColorRGBA(.333f, .227f, 0f, 1f)

}