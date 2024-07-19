ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "Scala_project",
      libraryDependencies ++= Seq(
          "org.scalatest" %% "scalatest" % "3.2.19" % Test,
          "org.scalatest" %% "scalatest-flatspec" % "3.2.19" % Test,
          "dev.zio" %% "zio-json" % "0.6.2",
          "dev.zio" %% "zio" % "2.0.0",
          "dev.zio" %% "zio-console" % "2.0.0",
          "dev.zio" %% "zio-interop-cats" % "3.2.9.0"
      )
)
