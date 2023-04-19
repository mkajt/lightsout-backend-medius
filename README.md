# Lights Out Puzzle Game
Welcome to Lights Out - a puzzle game that will challenge your mind and keep you entertained for hours! This game consists of two projects - the backend and frontend - which work together to provide a seamless gaming experience.

## Backend
The backend is built with Spring Boot, uses hibernate and spring data jpa to manage a h2 database with three tables: Problem, Solution, and Solution_step. It exposes several rest APIs that allow users to retrieve and create problems and solutions (swagger is available at: '/openapi/swagger-ui/index.html#/'). To solve the puzzles, Lights Out uses an algorithm called Light Chasing, which is sure to keep you on your toes. You can run the backend by using the commands **mvn clean install** and **mvn spring-boot:run** or by simply running it in Intellij Idea.

## Frontend
The frontend is built with Angular and Bootstrap, is easy to use and designed with mobile devices in mind. It consists of three parts: solve problem, create problem, and instructions. The solve problem section allows you to select a problem size and attempt to solve it by clicking on the board. If you get stuck, you can click "get solution" for help or reset the board entirely. The create problem section lets you build your own puzzles by clicking on the board and then checking for a solution. In the instructions section, you can learn more about the game and its rules. To run the frontend, use the commands **npm install** and **npm run start** or simply run it in Webstorm.

Lights Out is a fun and challenging game that will put your puzzle-solving skills to the test - give it a try today!
