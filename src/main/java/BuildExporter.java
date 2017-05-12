import com.kylemoore.ge.api.BuildMetadata;
import com.kylemoore.ge.api.BuildMetadataEnhancement;
import com.kylemoore.ge.api.GradleBuildExporter;

import javax.script.Bindings;
import javax.script.SimpleBindings;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

public class BuildExporter {

  public static void main( String[] args ) {
    ZonedDateTime jan10 = ZonedDateTime.of(2017, 1, 10, 0, 0, 0, 0, ZoneOffset.UTC);
    
    List<BuildMetadata> builds = GradleBuildExporter.getmake()
        .since(jan10)
        .execute();

    Bindings b = new SimpleBindings((SimpleBindings) builds.get(0));
    
    for (Object build : builds) {
      System.out.printf("Build %s compiled Java in %s, Gosu in %s. Link -> %s", 
          ((BuildMetadata) build).getpublicBuildId(), 
          BuildMetadataEnhancement.getJavaCompilationTime(build), 
          BuildMetadataEnhancement.getGosuCompilationTime(build), 
          BuildMetadataEnhancement.getURL(build));
    }
  }
  
}
