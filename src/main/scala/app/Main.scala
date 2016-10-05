/*
 * Copyright (c) 2016. All rights reserved by Andrzej Tuchołka (andrzej@certo.co)
 */

package app

class Main extends com.jme3.app.SimpleApplication with Settings {

  private lazy val logger = org.slf4j.LoggerFactory.getLogger(getClass.getName)

  start(com.jme3.system.JmeContext.Type.Display)

  lazy val guiState = new gui.GuiState(guiNode)

//  lazy val debugState = new debug.DebugState()
//  lazy val simulatorState = new sim.SimulatorState()
//  lazy val sfxState = new sfx.SfxState()

  def simpleInitApp() = {

    flyCam.setEnabled(false)

  }
}