Code runs, but two issues:
 # Studio's *.gsp runner does not include resource roots on the classpath (incidentally, the ordering of build/classes/main, then build/classes/test is also wrong)
   - Workaround: manually copy src/main/resources/serverconfig.properties to build/classes/main
 # Something's wrong with the ServiceFactory and the coercion manager
