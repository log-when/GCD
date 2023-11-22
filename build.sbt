scalaVersion := "2.13.10"

scalacOptions ++= Seq(
  "-feature",
  "-language:reflectiveCalls",
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)

// Chisel 3.6
addCompilerPlugin("cn.ac.ios.tis" % "chisel3-plugin" % "3.6-SNAPSHOT" cross CrossVersion.full)
libraryDependencies ++= Seq(
  "cn.ac.ios.tis" %% "chisel3" % "3.6-SNAPSHOT",
  "cn.ac.ios.tis" %% "chiseltest" % "0.7-SNAPSHOT")
