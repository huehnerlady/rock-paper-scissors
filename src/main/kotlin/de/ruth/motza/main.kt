package de.ruth.motza

fun main() {
  println("Welcome to rock-paper-scissors")
  print("Start playing")
  repeat(3){
    Thread.sleep(2000)
    print(".")
  }
  println()
  val result = Game().play()
  println("The results are in:")
  println("Player 1: ${result.winPlayer1} wins")
  println("Player 2: ${result.winPlayer2} wins")
  println("Draws: ${result.draws}")
  println("And the winner is .... ${result.winner}")
}
