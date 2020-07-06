lazy val scala212 = "2.12.10"
lazy val supportedScalaVersions = List(scala212)
ThisBuild / scalaVersion := scala212
ThisBuild / turbo := true

lazy val root = project.in(file(".")).
    aggregate(crossed.js, crossed.jvm).
    settings(
      crossScalaVersions := Nil,
      publish / skip := true
    )


lazy val crossed = crossProject(JSPlatform, JVMPlatform).in(file(".")).
    settings(
      name := "scoreboard",
      organization := "org.homermultitext",
      version := "1.0.0",
      licenses += ("GPL-3.0",url("https://opensource.org/licenses/gpl-3.0.html")),
      /*
      resolvers += Resolver.jcenterRepo,
      resolvers += Resolver.bintrayRepo("neelsmith", "maven"),
      libraryDependencies ++= Seq(
        "org.scalatest" %%% "scalatest" % "3.1.2" % "test",
        "org.wvlet.airframe" %%% "airframe-log" % "20.5.2",
        "edu.holycross.shot.cite" %%% "xcite" % "4.3.0",
        "edu.holycross.shot" %%% "ohco2" % "10.19.0",

      )*/
    ).jvmSettings(
      /*
      libraryDependencies ++= Seq(
        "org.scala-js" %% "scalajs-stubs" % "1.0.0" % "provided",
        "com.github.pathikrit" %% "better-files" % "3.5.0",
        "edu.holycross.shot" %% "xmlutils" % "2.0.0",
      )*/
    ).
    jsSettings(
      // JS-specific settings:
      scalaJSUseMainModuleInitializer := true,
    )
