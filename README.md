# Person MS
* Running on port 8090
* WebService to be consumed
* Step by step:
    * First look at the file in `resources/person.xsd` it will say what is possible to do with this web service when it is up!
    * To let maven generate those files we need the specification below on `pom.xml` file:
      ```
      <plugin>
          <groupId>org.codehaus.mojo</groupId>
          <artifactId>jaxb2-maven-plugin</artifactId>
          <version>1.6</version>
          <executions>
              <execution>
                  <id>xjc</id>
                  <goals>
                      <goal>xjc</goal>
                  </goals>
              </execution>
          </executions>
          <configuration>
              <schemaDirectory>${project.basedir}/src/main/resources/</schemaDirectory>
              <outputDirectory>${project.basedir}/src/main/java</outputDirectory>
              <clearOutputDir>false</clearOutputDir>
          </configuration>
      </plugin>
      ```
      With this plugin maven will generate all java classes that was specified on the `resources/person.xsd` file.
    * Once you have the application running, go to this URL to see what the consumers will need: `http://localhost:8090/ws/generatingPeople.wsdl`
      (if you wanto to change this URL go to the file `config/SoapConfig.java` and confugure as tou want)