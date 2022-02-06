name := "uploader-byte-array-to-ipfs"

version := "0.1"

scalaVersion := "2.11.8"
resolvers += "jitpack" at "https://jitpack.io"
// https://mvnrepository.com/artifact/org.json4s/json4s-jackson
libraryDependencies += "org.json4s" %% "json4s-jackson" % "4.0.4"
// https://mvnrepository.com/artifact/org.scalaj/scalaj-http
libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.4.2"
// https://mvnrepository.com/artifact/com.github.ipfs/java-ipfs-http-client
libraryDependencies += "com.github.ipfs" % "java-ipfs-http-client" % "v1.3.3"




assemblyJarName in assembly := "uploader-byte-array-to-ipfs_2.12-0.1.jar"

// META-INF discarding
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}