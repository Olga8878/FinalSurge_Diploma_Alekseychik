## FinalSurge automatic tests

Final Surge® is the coach, team, club, and athlete training platform . Always free to athletes, Final Surge empowers athletes and coaches to reach fitness and performance excellence like never before.
## Project Description
This code represents a set of tests for automated testing of an application using Selenium and TestNG. It describes various test scenarios for verifying the functionality of the application, such as logging in, creating and editing workouts, creating equipment, uploading files and etc.
## Setting up config
1. Clone this repository.
   https://github.com/Olga8878/FinalSurge_Diploma_Alekseychik.git

2. Enter email and password in config.properties.

3. You can specify the browser (Chrome or Firefox) you want to use in the parameters "browser" of the regression.xml, negative.xml, smoke.xml files, the default is Chrome.
## Installation:
* IDE: IntelliJ
* Programming Language: JAVA
* Project Type: Maven
## Patterns used:
*  Page Object
* Element Decorators
* Value Object
* Builder
* Enums
* Lombok

## Checklist:
1. Verify that user can log in the system.
2. Verify successful creation of bike with valid data.
3. Verify successful deletion of bike.
4. Verify successful file upload with valid data.
5. Verify unsuccessful file upload with invalid extension.
6. Verify that user can report on workouts of the selected type for the selected period.
7. Verify that user can open print page with workouts for the selected time period. 8.
8. Verify successful workout creation with valid data(Filling form Quick Workout).
9. Verify successful calculator training calories.
10. Verify calculator height validation(negative).
11. Verify calculator age validation(negative).
12. Verify calculator if one input is empty with dataProvider.

## TestNG command for running all tests and getting report:
* mvn clean test

* allure generate target/allure-results

* allure serve target/allure-results

