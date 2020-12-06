package de.ruth.motza

import io.kotest.core.spec.style.DescribeSpec
import io.mockk.mockk
import io.mockk.verify

class GameTest : DescribeSpec() {

  private val round = mockk<Round>()
  private val game = Game(round)

  init {

  }
}
