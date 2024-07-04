ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "Scala_project",
    libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.2.19" % "test"),
    libraryDependencies ++= Seq("org.scalatest" %% "scalatest-flatspec" % "3.2.19" % "test")
  )
