lazy val root = project
  .enablePlugins(ScalaJSPlugin)

enablePlugins(WorkbenchPlugin)

name := "scalajs-sortable-demos"

version := "0.2"

scalaVersion := "2.12.1"


libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "net.scalapro" %%% "sortable-js-facade" % "0.2.1"
)

jsDependencies ++= Seq(
  "org.webjars.bower" % "github-com-RubaXa-Sortable" % "1.4.2"
    / "1.4.2/Sortable.js" minified "Sortable.min.js"
)

//resolvers +=
//  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
