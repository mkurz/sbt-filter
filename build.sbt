lazy val `sbt-filter` = (project in file(".")).enablePlugins(SbtWebBase)

organization := "com.slidingautonomy.sbt"

name := "sbt-filter"

version := "1.0.2-SNAPSHOT"

scalacOptions += "-feature"

resolvers ++= Seq(
  Resolver.mavenLocal
)

addSbtJsEngine("1.2.3")

//scriptedSettings

//scriptedLaunchOpts += s"-Dproject.version=${version.value}"

publishMavenStyle := true

publishTo := {
  if (isSnapshot.value) Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
  else Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
}

pomExtra :=
  <url>https://github.com/rgcottrell/sbt-filter</url>
  <licenses>
    <license>
      <name>Apache License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:rgcottrell/sbt-filter.git</url>
    <connection>scm:git:git@github.com:rgcottrell/sbt-filter.git</connection>
  </scm>
  <developers>
    <developer>
      <id>rgcottrell</id>
      <name>Robert Cottrell</name>
      <url>https://github.com/rgcottrell</url>
    </developer>
  </developers>
