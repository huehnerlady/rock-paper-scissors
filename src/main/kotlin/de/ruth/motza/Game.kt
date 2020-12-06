package de.ruth.motza

class Game(private val round: Round = Round()) {

  fun play() {
    repeat(100) {
      round.play()
    }
  }
}
