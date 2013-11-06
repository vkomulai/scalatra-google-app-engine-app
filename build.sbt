import sbtappengine.Plugin.{AppengineKeys => gae}

name := "sample"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scalatra" % "scalatra_2.10" % "2.0.5" withSources,
  "com.samskivert" %% "highchair-datastore" % "0.0.5" withSources,
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"
)

appengineSettings

(gae.onStartHooks in gae.devServer in Compile) += { () =>
  println("hello")
}

(gae.onStopHooks in gae.devServer in Compile) += { () =>
  println("bye")
}

appengineDataNucleusSettings

gae.persistenceApi in gae.enhance in Compile := "JDO"
