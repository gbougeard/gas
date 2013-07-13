import sbt._
import sbt.Keys._

object GasBuild extends Build {

  lazy val gas = Project(
    id = "gas",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "gas",
      organization := "org.gbougeard",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2"
      // add other settings here
    )
  )
}
