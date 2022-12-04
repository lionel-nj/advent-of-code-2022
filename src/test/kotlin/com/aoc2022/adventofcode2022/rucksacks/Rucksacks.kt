package com.aoc2022.adventofcode2022.rucksacks

import com.aoc2022.adventofcode2022.utils.Utils.Companion.getPriority
import com.aoc2022.adventofcode2022.utils.Utils.Companion.readFile
import com.aoc2022.adventofcode2022.utils.Utils.Companion.toCharList
import org.junit.jupiter.api.Test

class Rucksacks {

    @Test
    fun rucksackPriorities() {
        val inputStream = readFile("/rucksacks.txt")
        // 1st question
        val priorities = inputStream.bufferedReader().readLines().map {
            RucksackGroup.Rucksack(it.toCharList())
        }.map {
            it.getCommonType().let { commonType -> commonType!!.getPriority() }
        }
        println("Answer to question #1 is: ${priorities.sumOf { it }}")

        // 2nd question
        val otherIS = readFile("/rucksacks.txt")
        val lines = otherIS.bufferedReader().readLines()
        val prioritySum = (0..lines.size - 3 step 3).map {
            RucksackGroup(
                RucksackGroup.Rucksack(lines[it].toCharArray().toList()),
                RucksackGroup.Rucksack(lines[it + 1].toCharList()),
                RucksackGroup.Rucksack(lines[it + 2].toCharList())
            )
        }.sumOf { it.getCommonType().getPriority() }
        println("Answer to question #2 is: $prioritySum")
    }
}
