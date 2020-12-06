package de.ruth.motza

class Game(private val round: Round = Round()) {

  fun play(numberOfRounds: Int = 100) {
    repeat(numberOfRounds) {
      round.play()
    }
  }
}
