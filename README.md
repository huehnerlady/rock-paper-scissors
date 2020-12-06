## The Task

Write a program that plays multiple rounds of Rock, Paper, Scissors (https://en.wikipedia.org/wiki/Rock-paper-scissors) and shows the final results of the game.  
The code should at least provide the minimal functional requirements listed below, have high test coverage and adhere to common clean code rules.

KEEP IT SIMPLE - remember: we're not looking for a full-blown business application, but a basis for discussion and further development. A simple text output for the result will do.

Minimal functional requirements:

* One player should always play randomly, the other should always choose rock.  
* The application should play 100 rounds of the game  
* The application should evaluate the game logic, i.e. the result (e.g. WIN, DRAW, LOSE) of two actions (e.g. ROCK, PAPER, SCISSOR) competing against each other  
* The application should calculate at least the number of wins for each player and the number of draws.  


Technical requirements:

Language: Kotlin, tests in a language and with a framework of your choice  
Approach: ideally "test-driven

## Usage

* To build the project and run its tests please use `./gradlew build`
* The test results can be found at the following location: `build/reports/tests/test/index.html`
* To run the programme please use `./gradlew run`


## My desicions

* I chose gradle as a build tool with the kotlin DSL as this is my preffered option and I am most familiar with it
* I chose Kotlin jvm as I am most familiar with this platform  
* I chose kotest as my test framework as I worked with this before and always enjoyed it. We use spock for our groovy tests and kotest is the best alternative in the kotlin world I found so far.
* I did not write a test for the random function of the GameAction.  
  I chose not to do so after I started writing the test and were not able to statically mock the extention function as `Array<GameAction>::random` results in the compiler error:   
  ```
  Cannot choose among the following candidates without completing type inference:  
  public inline fun <T> Array<out GameAction>.random(): GameAction defined in kotlin.collections
  public fun <T> Array<out GameAction>.random(random: Random): GameAction defined in kotlin.collections
  ```
