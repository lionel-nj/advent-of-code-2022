package com.aoc2022.adventofcode2022.rps

enum class GameOption(
    private val score: Int
) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    fun getScore(): Int {
        return this.score
    }

    fun winsBefore(): GameOption {
        return when (this) {
            ROCK -> SCISSORS
            PAPER -> ROCK
            SCISSORS -> PAPER
        }
    }

    fun losesBefore(): GameOption {
        return when (this) {
            ROCK -> PAPER
            PAPER -> SCISSORS
            SCISSORS -> ROCK
        }
    }

    companion object {
        private val gameOptionMap = mapOf(
            Pair("A", ROCK),
            Pair("X", ROCK),
            Pair("B", PAPER),
            Pair("Y", PAPER),
            Pair("C", SCISSORS),
            Pair("Z", SCISSORS)
        )

        fun create(sign: String): GameOption {
            return gameOptionMap[sign]!!
        }
    }
}
