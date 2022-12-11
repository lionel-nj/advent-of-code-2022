package com.aoc2022.adventofcode2022.markers

class AocSignal(private val line: String) {

    fun splitBy(count: Int): Map<Int, List<Char>> {
        val lineAsList = line.toList()
        return (0..line.length - count).associateWith { lineAsList.subList(it, it + count) }
    }
}
