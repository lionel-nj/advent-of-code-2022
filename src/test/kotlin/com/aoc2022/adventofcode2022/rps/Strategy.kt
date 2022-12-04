package com.aoc2022.adventofcode2022.rps

class Strategy(
    private val opponentMove: GameOption,
    private val elfSuggestion: ElfSuggestion
) {

    fun suggestMove(): GameOption {
        return when (elfSuggestion) {
            ElfSuggestion.WIN -> opponentMove.losesBefore()
            ElfSuggestion.DRAW -> opponentMove
            ElfSuggestion.LOOSE -> opponentMove.winsBefore()
        }
    }
}
