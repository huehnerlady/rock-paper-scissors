package de.ruth.motza

import de.ruth.motza.Winner.DRAW
import de.ruth.motza.Winner.PLAYER_1
import de.ruth.motza.Winner.PLAYER_2

class Game(private val round: Round = Round()) {

  fun play(numberOfRounds: Int = 100): GameResult {
    val rounds = generateSequence { round.play() }.take(numberOfRounds).toList()
    val results = rounds
      .map { it.getWinner() }
      .groupingBy { it }
      .eachCount()
    return GameResult(
      winPlayer1 = results.getOrDefault(PLAYER_1, 0),
      winPlayer2 = results.getOrDefault(PLAYER_2, 0),
      draws = results.getOrDefault(DRAW, 0)
    )
  }
}
