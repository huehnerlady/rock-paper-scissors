package de.ruth.motza

enum class GameAction {
  ROCK,
  PAPER,
  SCISSOR;

  companion object {
    fun random(): GameAction = values().random()
  }
}

