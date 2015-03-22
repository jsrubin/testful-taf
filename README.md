# testful-taf
Testful is a software architecture consisting of guidelines and best practices for creating test automation frameworks.

##Pre-requisites/Good to know
- Java 8 support

##Run
- mvn clean test

##Debug (Eclipse)
- mvn test -Dmaven.surefire.debug test

- Remote Java Application
- ***Project: testful-taf***
- ***Connection Type: Standard (Socket Attach)***
- ***Host: localhost***
- ***Port: 5005***

##Feature Highlights
- ***DB validation switch***            Ability to turn on/off DB validation
- ***Custom 'Step' log level***        	Custom log level which prints high level test steps
- ***Groups***             				Groups TestNG Annotation parameter
- ***Pre Sanity***             			Sanity test environment (ui, service, db) in beforeSuite
- ***Post Log Sweep***            		Sweep ui and service logs for error or warnings
- ***UI console validation***      	 	Validate no errors in the UI console
- ***Retry failures***      	 		Retry failed tests, including dataProvider tests
- ***CustomTestName***   				Create a custom annotation Test name when using dataProvider
- ***Abstracting validation***   		Handling validation and intercepting exceptions of Tests using custom annoation
- ***Error/Failure Reporting***   		Handling and reporting errors vs failures