package de.ruth.motza

import de.ruth.motza.Winner.*
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ExtentionsKtTest : DescribeSpec() {

  init {
    describe("getWinner()") {
      listOf(
        row(GameAction.ROCK, GameAction.ROCK, DRAW),
        row(GameAction.ROCK, GameAction.PAPER, PLAYER_2),
        row(GameAction.ROCK, GameAction.SCISSORS, PLAYER_1),
        row(GameAction.PAPER, GameAction.ROCK, PLAYER_1),
        row(GameAction.PAPER, GameAction.PAPER, DRAW),
        row(GameAction.PAPER, GameAction.SCISSORS, PLAYER_2),
        row(GameAction.SCISSORS, GameAction.ROCK, PLAYER_2),
        row(GameAction.SCISSORS, GameAction.PAPER, PLAYER_1),
        row(GameAction.SCISSORS, GameAction.SCISSORS, DRAW)
      ).map { (actionPlayer1, actionPlayer2, winner) ->
        it("$actionPlayer1 and $actionPlayer2 should result in $winner") {
          Pair(actionPlayer1, actionPlayer2).getWinner() shouldBe winner
        }
      }
    }
  }
}
