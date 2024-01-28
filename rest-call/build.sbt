val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "rest-call",
    version := "1.0.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "com.lihaoyi" %% "ujson" % "1.4.0",
    libraryDependencies += "com.lihaoyi" %% "upickle" % "1.4.0",
    libraryDependencies += "com.softwaremill.sttp.client4" %% "core" % "4.0.0-M8",
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
  )
