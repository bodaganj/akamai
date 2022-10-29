# Akamai tests

## Tech stack

* Java 11
* JBehave
* Serenity
* maven
* git/github

JBehave is used in order to have test cases/stories written in easy to read format (for both technical and not technical persons). Serenity is used as a WebDriver wrapper.

## How to run tests

1. Run all stories
    * manually - run ```src/test/java/com/bitpanda/launcher/SerenityStoriesLauncher.java``` as a simple JUnit test
    * maven - run ```mvn clean verify```
2. Run single story
   * same steps to execute, but the following annotation ```@Metafilter("+single")``` should be added
     to ```src/test/java/com/akamai/launcher/SerenityStoriesLauncher.java```
     and appropriate story should be marked with the following tag ```Meta: @single```

*Note:* be aware that tests are executed using chrome browser in a headless mode. In order to disable this mode pls
remove ```chrome.switches``` property within the ```serenity.properties``` file

## How to get Serenity reports

If tests are executed with help of maven, then Serenity report is created automatically. You can find it
under ```${project.basedir}/target/site/index.html```