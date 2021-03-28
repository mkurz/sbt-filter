addSbtPlugin("com.slidingautonomy.sbt" % "sbt-filter" % sys.props("project.version"))

resolvers ++= Seq(
  Resolver.mavenLocal,
)
