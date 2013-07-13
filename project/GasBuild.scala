import sbt._
import sbt.Keys._

object GasBuild extends Build {

  val buildName         = "gas"

  val mandubianRepo = Seq(
    "Mandubian repository snapshots" at "https://github.com/mandubian/mandubian-mvn/raw/master/snapshots/",
    "Mandubian repository releases" at "https://github.com/mandubian/mandubian-mvn/raw/master/releases/"
  )

  lazy val gas = Project(
    buildName, file("."),
    settings = BuildSettings ++ Seq(
      resolvers ++= mandubianRepo,
      libraryDependencies ++= Seq(
        "play-json-zipper"  %% "play-json-zipper"  % "0.1-SNAPSHOT"             ,
        "play"        %% "play-json" % "2.2-SNAPSHOT",
        "org.specs2"  %% "specs2" % "1.13" % "test",
        "junit"        % "junit" % "4.8" % "test"
      )
    )
  )

  val BuildSettings = Defaults.defaultSettings ++ Seq(
    scalaVersion := "2.10.0",
    organization := "org.gbougeard",
    resolvers ++= mandubianRepo
  )
//  ++ Publish.settings


//  lazy val main = Project(
//    id = buildName,
//    base = file("."),
//    settings = BuildSettings ++ Seq(
//      publish      := {}
//    )
//  ) aggregate(core)
//
//  lazy val core = Project(
//    id = "core",
//    base = file("core"),
//    settings = BuildSettings ++ Seq(
//      libraryDependencies ++= Seq(
////        "play-json-zipper"  %% "play-json-zipper"  % "0.1-SNAPSHOT"             ,
//        "play"              %% "play-json"         % "2.2-SNAPSHOT"             ,
////        "play"              %% "play"              % "2.1.1"        % "provided",
//        "org.specs2"        %% "specs2"            % "1.13"         % "test"    ,
//        "junit"              % "junit"             % "4.8"          % "test"    ,
//        "joda-time"          % "joda-time"         % "2.2"
//      )
//    )
//  )

}
