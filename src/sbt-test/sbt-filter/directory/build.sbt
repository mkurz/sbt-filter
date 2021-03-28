lazy val root = (project in file(".")).enablePlugins(SbtWeb)

filter / includeFilter  := "temp" || "*.coffee"

pipelineStages := Seq(filter)
