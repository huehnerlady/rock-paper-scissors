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

    val winPlayer1 = results.getOrDefault(PLAYER_1, 0)
    val winPlayer2 = results.getOrDefault(PLAYER_2, 0)
    val winner = when{
      winPlayer1 > winPlayer2 -> "Player 1"
      winPlayer2 > winPlayer1 -> "Player 2"
      else -> "Nobody"
    }

    return GameResult(
      winPlayer1 = winPlayer1,
      winPlayer2 = winPlayer2,
      draws = results.getOrDefault(DRAW, 0),
      winner = winner
    )
  }
}
