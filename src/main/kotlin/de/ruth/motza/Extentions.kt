package de.ruth.motza

import de.ruth.motza.GameAction.PAPER
import de.ruth.motza.GameAction.ROCK
import de.ruth.motza.GameAction.SCISSORS
import de.ruth.motza.Winner.DRAW
import de.ruth.motza.Winner.PLAYER_1
import de.ruth.motza.Winner.PLAYER_2

fun Pair<GameAction, GameAction>.getWinner(): Winner = when (this) {
  Pair(ROCK, PAPER) -> PLAYER_2
  Pair(ROCK, SCISSORS) -> PLAYER_1
  Pair(PAPER, ROCK) -> PLAYER_1
  Pair(PAPER, SCISSORS) -> PLAYER_2
  Pair(SCISSORS, ROCK) -> PLAYER_2
  Pair(SCISSORS, PAPER) -> PLAYER_1
  else -> DRAW
}
