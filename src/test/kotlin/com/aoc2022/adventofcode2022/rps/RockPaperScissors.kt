package com.aoc2022.adventofcode2022.rps

import com.aoc2022.adventofcode2022.utils.Utils.Companion.readFile
import org.junit.jupiter.api.Test

class RockPaperScissors {

    @Test
    fun rockPaperScissors() {
        val inputStream = readFile("/rock-paper-scissors.txt")
        val score = inputStream.bufferedReader().readLines().map {
            val line = it.split(" ")
            val opponentMove = GameOption.create(line[0])
            val elfSuggestion = ElfSuggestion.create(line[1])
            val myMove = Strategy(opponentMove, elfSuggestion).suggestMove()
            Round(
                opponentMove = opponentMove,
                myMove = myMove
            )
                .getScore()
        }.sumOf { it }
        println("Answer to question #2 is: $score")
    }
}
