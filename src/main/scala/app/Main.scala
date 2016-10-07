/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package app

class Main(headless: Boolean = false) extends com.jme3.app.SimpleApplication with Settings {

  private lazy val logger = org.slf4j.LoggerFactory.getLogger(getClass.getName)

  lazy val guiState = new gui.GuiState(guiNode)

  //  lazy val debugState = new debug.DebugState()
  //  lazy val simulatorState = new sim.SimulatorState()
  //  lazy val sfxState = new sfx.SfxState()

  if (headless) start(com.jme3.system.JmeContext.Type.Headless)
  else start(com.jme3.system.JmeContext.Type.Display)


  def simpleInitApp() = {

    flyCam.setEnabled(false)

  }
}