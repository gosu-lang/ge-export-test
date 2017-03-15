A demonstration project for the ge-export API for extracting data from a Gradle Enterprise server.

Requirements:
- JDK 8
- IJ 15.0.6 (CE is sufficient)
- OS Gosu plugin 

Setup: 
1. Open IJ 15, create a SDK pointing to JDK 8's location. Then install the latest OS Gosu plugin and restart.
2. After restarting, open a new project and choose the build.gradle in this directory.
3. Configure `serverconfig.properties` as necessary. 
4. Find src/main/gosu/BuildExporter.gsp, right-click and choose `Run 'BuildExporter'`
5. If the execution fails, see known issues below re: location of serverconfig.properties file.

Known issue(s):
- IDE-3994 Studio's *.gsp runner does not include resource roots on the classpath (incidentally, the ordering of build/classes/main, then build/classes/test is also wrong)
  - Workaround: manually copy src/main/resources/serverconfig.properties to build/classes/main
- Runtime dependency on tools.jar is required. This would preferably be provided by ge-export's POM.
