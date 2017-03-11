uses java.time.ZoneOffset
uses java.time.ZonedDateTime

uses com.guidewire.ge.api.GradleBuildExporter

var builds = GradleBuildExporter.make
  .since(ZonedDateTime.of(2017, 1, 10, 0, 0, 0, 0, ZoneOffset.UTC))
  .withTag("pekin")
  .execute()

builds.each(\build -> print("Build ${build.publicBuildId} compiled Java in ${build.JavaCompilationTime}, Gosu in ${build.GosuCompilationTime}. Link -> ${build.URL}"))