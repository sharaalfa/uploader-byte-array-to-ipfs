name := "uploader-byte-array-to-ipfs"

version := "0.1"

scalaVersion := "2.11.4"

lazy val root = (project in file("."))
  .settings(Seq(npmSrcDir := "spa"))
  .enablePlugins(PlayScala)

// https://mvnrepository.com/artifact/org.json4s/json4s-jackson
libraryDependencies += "org.json4s" %% "json4s-jackson" % "4.0.4"
// https://mvnrepository.com/artifact/org.scalaj/scalaj-http
libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.4.2"
// https://mvnrepository.com/artifact/org.projectlombok/lombok
libraryDependencies += "org.projectlombok" % "lombok" % "1.18.22" % "provided"
// https://mvnrepository.com/artifact/com.typesafe.play/play
libraryDependencies += "com.typesafe.play" %% "play" % "2.7.0"

libraryDependencies += guice

