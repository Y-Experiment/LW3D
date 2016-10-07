package test

import org.scalatest.{FeatureSpec, GivenWhenThen}

class AppSpec extends FeatureSpec with GivenWhenThen {

  info("As an app developer I want to be able to access the app, its settings and properties")

  feature("Application class") {
    scenario("can be instantiated") {
      Given("a default location app.Main for the app")
      When("the class is instantiated")
      val application = new app.Main()
      Then("the object should be instantiated")
      assert(application.isInstanceOf[app.Main])
    }
  }

}
