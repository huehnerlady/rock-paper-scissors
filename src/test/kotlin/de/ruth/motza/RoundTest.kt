package de.ruth.motza

import de.ruth.motza.GameAction.PAPER
import de.ruth.motza.GameAction.ROCK
import de.ruth.motza.GameAction.SCISSORS
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject

class RoundTest : DescribeSpec() {

  private val round = Round()

  init {
    describe("a round of a game") {
      it("the second player should be rock") {
        val result = round.play()

        result.second shouldBe ROCK
      }
      it("the first player should be random") {
        mockkObject(GameAction.Companion)
        every {
          GameAction.random()
        } returnsMany listOf(PAPER, SCISSORS)
        round.play().first shouldBe PAPER
        round.play().first shouldBe SCISSORS
      }
    }
  }
}
