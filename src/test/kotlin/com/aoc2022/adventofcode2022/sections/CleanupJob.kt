package com.aoc2022.adventofcode2022.sections

import com.aoc2022.adventofcode2022.utils.Utils
import org.junit.jupiter.api.Test

class CleanupJob {

    @Test
    fun cleanup() {
        var firstCounter = 0
        var secondCounter = 0
        Utils.readFile("/sections.txt").bufferedReader().readLines().map {
            val line = it.split(",")
            val firstAssignment = line[0]
            val secondAssignment = line[1]
            val firstElfSection = Section(
                firstAssignment.split("-")[0].toInt(),
                firstAssignment.split("-")[1].toInt()
            )
            val secondElfSection = Section(
                secondAssignment.split("-")[0].toInt(),
                secondAssignment.split("-")[1].toInt()
            )
            if (firstElfSection.containsAll(secondElfSection) || secondElfSection.containsAll(firstElfSection)) {
                firstCounter += 1
            }
            if (firstElfSection.intersect(secondElfSection)) {
                secondCounter += 1
            }
        }
        println("Answer to the first question is: $firstCounter")
        println("Answer to the second question is: $secondCounter")
    }
}
