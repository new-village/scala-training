val scala3Version = "3.3.1"
val sparkVersion = "3.5.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "hello-spark",
    version := "0.1.0-SNAPSHOT",
    fork := true,

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    libraryDependencies ++= Seq(
      ("org.apache.spark" %% "spark-core" % sparkVersion),
      ("org.apache.spark" %% "spark-sql" % sparkVersion),
    ).map(_.cross(CrossVersion.for3Use2_13)),

  )
