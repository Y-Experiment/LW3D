/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package app

import states._

class Main(headless: Boolean = false) extends com.jme3.app.SimpleApplication with Settings {

  private lazy val logger = java.util.logging.Logger.getLogger(getClass.getName)

  lazy val guiState = new GuiState(guiNode)

  lazy val debugState = new DebugState(rootNode)
  lazy val environmentState = new EnvironmentState(rootNode)
  lazy val simulatorState = new SimulatorState(rootNode)
  lazy val sfxState = new SfxState(rootNode)

  if (headless) start(com.jme3.system.JmeContext.Type.Headless)
  else start(com.jme3.system.JmeContext.Type.Display)


  def simpleInitApp() = {
    flyCam.setEnabled(false)
    stateManager.attachAll(debugState, guiState, environmentState, simulatorState, sfxState)
  }
}