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
