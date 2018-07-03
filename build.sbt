import sbt.Keys.{libraryDependencies, version}

lazy val server = (project in file("server"))
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin) // use the standard directory layout instead of Play's custom
  .settings(
  name := """play-macwire-realworld""",

  version := "0.0.1-SNAPSHOT",
  scalaVersion := "2.12.6",

  libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
  libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.1" % "provided"
)

// loads the Play server project at sbt startup
onLoad in Global ~= (_ andThen ("project server" :: _))


