package de.ruth.motza

enum class GameAction {
  ROCK,
  PAPER,
  SCISSORS;

  companion object {
    fun random(): GameAction = values().random()
  }
}

enum class Winner{PLAYER_1, PLAYER_2, DRAW}

data class GameResult(val winPlayer1: Int = 0, val winPlayer2: Int = 0, val draws: Int = 0, val winner: String)
