scalaVersion := "2.12.15"

scalacOptions ++= Seq(
  "-feature",
  "-language:reflectiveCalls",
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)

// Chisel 3.7
addCompilerPlugin("edu.berkeley.cs" % "chisel3-plugin" % "3.7-SNAPSHOT" cross CrossVersion.full)
libraryDependencies ++= Seq(
  "edu.berkeley.cs" %% "chisel3" % "3.7-SNAPSHOT",
  "edu.berkeley.cs" %% "chiseltest" % "0.7-SNAPSHOT")
