ThisBuild / scalaVersion := "2.13.3"

lazy val root = (project in file("."))
  .settings(

    name := "scalajs-sortable-demos",

    version := "0.3",

    scalaVersion := "2.13.3",


    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "1.0.0",
      "net.scalapro" %%% "sortable-js-facade" % "1.0.0"
    )
  ).enablePlugins(ScalaJSPlugin, JSDependenciesPlugin)





