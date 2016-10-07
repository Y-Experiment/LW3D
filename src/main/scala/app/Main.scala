/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package app

class Main extends com.jme3.app.SimpleApplication with Settings {

  lazy val guiState = new gui.GuiState(guiNode)

  start(com.jme3.system.JmeContext.Type.Display)
  private lazy val logger = org.slf4j.LoggerFactory.getLogger(getClass.getName)

  //  lazy val debugState = new debug.DebugState()
  //  lazy val simulatorState = new sim.SimulatorState()
  //  lazy val sfxState = new sfx.SfxState()

  def simpleInitApp() = {

    flyCam.setEnabled(false)

  }
}