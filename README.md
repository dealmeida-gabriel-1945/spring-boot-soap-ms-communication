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

# Car MS
* Running on port 8091
* WebService to be consumed
* Its pretty the same thing with Person MS

# Consumer MS
* Running on port 8092
* WebService to consume Car MS and Person MS
* Inside the directory `resources/wsdl/*` we need to create wsdl files for each webservice SOAP we want to consume.
  * In that case, you can access the wsdl data from Person MS and Car MS by entering in this URL (with the MSs running):
    * `http://localhost:8090/ws/generatingPeople.wsdl`
    * `http://localhost:8091/ws/generatingCars.wsdl`
* Inside the file `config/SoapConfig.java` we need to specify which package the marshaller need to watch.
* Inside de package `service/feignClients/*` we will build ours feign clients to retrieve the data from Car MS and Person MS.

