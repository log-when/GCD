scalaVersion := "2.13.10"

scalacOptions ++= Seq(
  "-feature",
  "-language:reflectiveCalls",
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)

// Chisel 3.6
addCompilerPlugin("edu.berkeley.cs" % "chisel3-plugin" % "3.6-SNAPSHOT" cross CrossVersion.full)
libraryDependencies ++= Seq(
  "edu.berkeley.cs" %% "chisel3" % "3.6-SNAPSHOT",
  "edu.berkeley.cs" %% "chiseltest" % "0.7-SNAPSHOT")
