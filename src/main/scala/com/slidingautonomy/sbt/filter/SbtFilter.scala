package com.slidingautonomy.sbt.filter

import sbt._
import sbt.Keys._
import com.typesafe.sbt.jse.SbtJsTask
import com.typesafe.sbt.web.pipeline.Pipeline

object Import {

  val filter = TaskKey[Pipeline.Stage]("filter", "Filter intermediate files on the asset pipeline.")

}

object SbtFilter extends AutoPlugin {

  override def requires = SbtJsTask

  override def trigger = AllRequirements

  val autoImport = Import

  import autoImport._

  override def projectSettings = Seq(
    filter := runFilter.value,
    filter / includeFilter := NothingFilter,
    filter / excludeFilter := NothingFilter
  )

  private def runFilter: Def.Initialize[Task[Pipeline.Stage]] = Def.task {
    mappings =>

      val include = (filter / includeFilter).value
      val exclude = (filter / excludeFilter).value
      mappings.filter(f => exclude.accept(f._1) || !include.accept(f._1) || f._2.startsWith("lib/"))
  }

}
