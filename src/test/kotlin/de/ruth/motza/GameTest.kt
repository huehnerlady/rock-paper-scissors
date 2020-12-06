package de.ruth.motza

import io.kotest.core.spec.style.DescribeSpec
import io.mockk.mockk
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
  }
}
