# Selenium-Cucumber UI Automation test For Demo QA

### Install

Visit the Maven download page and download the version of Maven you want to install.

Add MAVEN_HOME System Variable

Add MAVEN_HOME Directory in PATH Variable

Verify Maven Installation

##### After checkout:

Download the version of Chromedriver matching your version of Google Chrome. Usually this is the latests version of chromedriver. 
Replace the current chromedriver in the project with the new version.

Run the project using the command line with:

```
mvn clean test

run with a tag : mvn clean test -Dcucumber.filter.tags="@exampleFeature"
```


### Technologies
* Cucumber-jvm:	5.3.0
* Selenium:		3.13.0
* Junit: 		4.12
* Java Commons: 2.6