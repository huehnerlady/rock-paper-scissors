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
        every { roundResult.getWinner() } returns PLAYER_1

        val result = game.play(10)

        result shouldBe GameResult(10, 0, 0)
      }
      it("should calculate wins for player2") {
        mockkStatic(Pair<GameAction, GameAction>::getWinner)
        val roundResult = mockk<Pair<GameAction, GameAction>>()
        every { round.play() } returns roundResult
        every { roundResult.getWinner() } returns PLAYER_2

        val result = game.play(10)

        result shouldBe GameResult(0, 10, 0)
      }
      it("should calculate draws") {
        mockkStatic(Pair<GameAction, GameAction>::getWinner)
        val roundResult = mockk<Pair<GameAction, GameAction>>()
        every { round.play() } returns roundResult
        every { roundResult.getWinner() } returns DRAW

        val result = game.play(10)

        result shouldBe GameResult(0, 0, 10)
      }
    }
  }
}
