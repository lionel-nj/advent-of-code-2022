package com.aoc2022.adventofcode2022.rps

import com.aoc2022.adventofcode2022.utils.Utils.Companion.readFile
import org.junit.jupiter.api.Test

class RockPaperScissors {

    @Test
    fun rockPaperScissors() {
        val inputStream = readFile("/rock-paper-scissors.txt")
        val dumbSolutionScores = emptyList<Int>().toMutableList()
        val smartSolutionScores = emptyList<Int>().toMutableList()
        inputStream.bufferedReader().readLines().map {
            val line = it.split(" ")
            val opponentMove = GameOption.create(line[0])
            val myMove = GameOption.create(line[1])
            dumbSolutionScores.add(
                Round(
                    opponentMove = opponentMove,
                    myMove = myMove
                )
                    .getScore()
            )
            val elfSuggestion = ElfSuggestion.create(line[1])

            smartSolutionScores.add(
                Round(
                    opponentMove = opponentMove,
                    myMove = Strategy(opponentMove, elfSuggestion).suggestMove()
                )
                    .getScore()
            )
        }
        println("Answer to question #1 is: ${dumbSolutionScores.sumOf { it }}")
        println("Answer to question #2 is: ${smartSolutionScores.sumOf { it }}")
    }
}
