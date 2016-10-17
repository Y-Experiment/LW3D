/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package helpers

import com.jme3.math.ColorRGBA

object ColorPalette {
  // http://paletton.com/#uid=72R0X0kllllaFw0g0qFqFg0w0aF
  lazy val MainColor = new ColorRGBA(.173f, .518f, .216f, 1f)
  lazy val MainBright = new ColorRGBA(.518f, .776f, .549f, 1f)
  lazy val MainDark = new ColorRGBA(0f, .259f, .031f, 1f)

  lazy val SecondColor = new ColorRGBA(.184f, .255f, .447f, 1f)
  lazy val SecondLight = new ColorRGBA(.475f, .525f, .675f, 1f)
  lazy val SecondDark = new ColorRGBA(.024f, .078f, .224f, 1f)

  lazy val HighColor = new ColorRGBA(.667f, .247f, .224f, .1f)
  lazy val HighLight = new ColorRGBA(1f, .682f, .667f, 1f)
  lazy val HighDark = new ColorRGBA(.333f, .016f, 0f, 1f)

  lazy val BackColor = new ColorRGBA(.667f, .525f, .224f, 1f)
  lazy val BackLight = new ColorRGBA(1f, .894f, .667f, 1f)
  lazy val BackDark = new ColorRGBA(.333f, .227f, 0f, 1f)

}