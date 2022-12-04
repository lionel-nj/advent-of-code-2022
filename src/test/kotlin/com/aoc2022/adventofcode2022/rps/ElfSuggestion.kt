package com.aoc2022.adventofcode2022.rps

enum class ElfSuggestion(private val suggestion: String) {
    LOOSE("X"),
    DRAW("Y"),
    WIN("Z");

    companion object {

        fun create(todo: String): ElfSuggestion {
            return ElfSuggestion.values().first { it.suggestion == todo }
        }
    }
}
