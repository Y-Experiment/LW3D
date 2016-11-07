/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package app

import com.jme3.post.FilterPostProcessor
import com.jme3.post.filters.BloomFilter

class Main(headless: Boolean = false) extends com.jme3.app.SimpleApplication with Settings {

  private lazy val logger = java.util.logging.Logger.getLogger(getClass.getName)

  lazy val guiState = new states.GuiState(guiNode)

  lazy val debugState = new states.DebugState(rootNode)
  lazy val environmentState = new states.EnvironmentState(rootNode)
  lazy val simulatorState = new states.SimulatorState(rootNode)
  lazy val sfxState = new states.SfxState(rootNode)

  if (headless) start(com.jme3.system.JmeContext.Type.Headless)
  else start(com.jme3.system.JmeContext.Type.Display)


  def simpleInitApp() = {
    flyCam.setEnabled(false)

    val processor = new FilterPostProcessor(assetManager)
    val bf: BloomFilter = new BloomFilter(BloomFilter.GlowMode.Objects)
    processor.addFilter(bf)
    viewPort.addProcessor(processor)

    stateManager.attachAll(debugState, guiState, environmentState, simulatorState, sfxState)
  }
}