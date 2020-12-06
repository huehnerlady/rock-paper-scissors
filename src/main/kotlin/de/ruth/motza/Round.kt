package de.ruth.motza

import de.ruth.motza.GameAction.ROCK

class Round {

  fun play(): Pair<GameAction, GameAction> {
    return Pair(GameAction.random(), ROCK)
  }
}
