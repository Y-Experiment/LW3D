/*
 * Copyright (c) 2016. Y Experiment (yexperiment.com) MIT License
 */

package app

trait Settings {
  this: com.jme3.app.SimpleApplication =>

  protected val appSettings = new com.jme3.system.AppSettings(true)

  Seq(
    ("Width", 1920)
    , ("Height", 1080)
    , ("BitsPerPixel", 32)
    , ("Frequency", 60)
    , ("DepthBits", 24)
    , ("StencilBits", 0)
    , ("Samples", 2)
    , ("Fullscreen", false)
    , ("Title", "Gomplex 3D")
    , ("Renderer", com.jme3.system.AppSettings.LWJGL_OPENGL2)
    , ("AudioRenderer", com.jme3.system.AppSettings.LWJGL_OPENAL)
    , ("DisableJoysticks", true)
    , ("UseInput", true)
    , ("VSync", false)
    , ("FrameRate", 0)
    , ("SettingsDialogImage", "")
    , ("MinHeight", 1920)
    , ("MinWidth", 1080)
  ) foreach { case (k, v: Object) => appSettings.put(k, v) }

  appSettings.setIcons({
    import javax.imageio.ImageIO

    List(
      ImageIO.read(getClass.getClassLoader.getResource("Yx/logo/Y256.png")),
      ImageIO.read(getClass.getClassLoader.getResource("Yx/logo/Y128.png")),
      ImageIO.read(getClass.getClassLoader.getResource("Yx/logo/Y64.png")),
      ImageIO.read(getClass.getClassLoader.getResource("Yx/logo/Y32.png")),
      ImageIO.read(getClass.getClassLoader.getResource("Yx/logo/Y16.png"))
    ).toArray
  })

  setSettings(appSettings)

  setShowSettings(false)
  setDisplayFps(true)
  setDisplayStatView(false)
  setPauseOnLostFocus(false)
}
