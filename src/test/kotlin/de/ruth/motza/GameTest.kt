package de.ruth.motza

import de.ruth.motza.Winner.DRAW
import de.ruth.motza.Winner.PLAYER_1
import de.ruth.motza.Winner.PLAYER_2
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify

class GameTest : DescribeSpec() {

  private val round = mockk<Round>(relaxed = true)
  private val game = Game(round)

  init {

    describe("rounds") {
      it("should play 100 rounds as default") {
        game.play()

        verify(exactly = 100) { round.play() }
      }
      it("should play 1 round if specified") {
        game.play(1)

        verify(exactly = 1) { round.play() }
      }
    }

    describe("win") {
      it("should calculate wins for player1") {
        mockkStatic(Pair<GameAction, GameAction>::getWinner)
        val roundResult = mockk<Pair<GameAction, GameAction>>()
        every { round.play() } returns roundResult
        every { roundResult.getWinner() } returnsMany listOf(DRAW, PLAYER_1, DRAW, PLAYER_2, PLAYER_1)

        val result = game.play(5)

        result shouldBe GameResult(2, 1, 2, "Player 1")
      }
      it("should calculate wins for player2") {
        mockkStatic(Pair<GameAction, GameAction>::getWinner)
        val roundResult = mockk<Pair<GameAction, GameAction>>()
        every { round.play() } returns roundResult
        every { roundResult.getWinner() } returnsMany listOf(DRAW, PLAYER_2, PLAYER_2, DRAW, PLAYER_1)

        val result = game.play(5)

        result shouldBe GameResult(1, 2, 2, "Player 2")
      }
      it("should calculate draws") {
        mockkStatic(Pair<GameAction, GameAction>::getWinner)
        val roundResult = mockk<Pair<GameAction, GameAction>>()
        every { round.play() } returns roundResult
        every { roundResult.getWinner() } returnsMany listOf(PLAYER_2, DRAW, DRAW, DRAW, PLAYER_1)

        val result = game.play(5)

        result shouldBe GameResult(1, 1, 3, "Nobody")
      }
    }
  }
}
