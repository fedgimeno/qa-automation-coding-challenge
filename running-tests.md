In order to run this test suite, please make sure you have the following installed:
* Java JDK 11 (or newer)
* Maven

1) Make sure that the application under test is running by opening a terminal and executing the `yarn start` command. Refer to the [setup.md](setup.md) file for more information. The application should be up and running at http://localhost:3000.
2) Open the root folder of this project in a terminal / command line and type `mvn clean test`, the dependencies should start downloading and the test execution will start.