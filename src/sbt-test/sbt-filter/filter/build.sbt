lazy val root = (project in file(".")).enablePlugins(SbtWeb)

filter / includeFilter := "*.coffee" || "*.map"

pipelineStages := Seq(filter)
