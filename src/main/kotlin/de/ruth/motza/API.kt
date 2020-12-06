package de.ruth.motza

enum class GameAction {
  ROCK,
  PAPER,
  SCISSORS;

  companion object {
    fun random(): GameAction = values().random()
  }
}

