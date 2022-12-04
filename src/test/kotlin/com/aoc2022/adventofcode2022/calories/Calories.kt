package com.aoc2022.adventofcode2022.calories

import com.aoc2022.adventofcode2022.utils.Utils.Companion.readFile
import org.junit.jupiter.api.Test

class Calories {

    @Test
    fun calories() {
        val caloriesPerElf = mapOf<Int, Int>().toMutableMap()
        val inputStream = readFile("/calories.txt")
        var elfIndex = 0
        var calories = 0
        inputStream.bufferedReader().forEachLine {
            if (it.isNotEmpty()) {
                calories += it.toInt()
            } else {
                caloriesPerElf.put(elfIndex, calories)
                elfIndex++
                calories = 0
            }
        }
        val mvp = caloriesPerElf.entries
            .sortedBy { it.value }
            .reversed()
            .associate { it.toPair() }
            .values
        println("Answer to question #1 is ${mvp.first()}")

        var topThreeCalorySum = (0..2).sumOf { mvp.elementAt(it) }
        println("Answer to question #2 is $topThreeCalorySum")
    }
}
