val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "s3-handler",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "com.amazonaws" % "aws-java-sdk-s3" % "1.12.651",
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "javax.xml.bind" % "jaxb-api" % "2.3.1",
      "org.apache.logging.log4j" % "log4j-core" % "2.22.1" % Runtime,
      "org.apache.logging.log4j" %% "log4j-api-scala" % "13.0.0"
    )
  )
