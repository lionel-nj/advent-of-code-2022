package com.aoc2022.adventofcode2022.sections

class Section(start: Int, end: Int) {
    private val range = (start..end).map { it }

    fun intersect(other: Section): Boolean {
        return this.range.intersect(other.range).isNotEmpty()
    }

    fun containsAll(other: Section): Boolean {
        return this.range.containsAll(other.range)
    }
}
