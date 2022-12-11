package com.aoc2022.adventofcode2022.markers

import com.aoc2022.adventofcode2022.utils.Utils
import com.aoc2022.adventofcode2022.utils.Utils.Companion.allUnique
import org.junit.jupiter.api.Test

class Markers {
    @Test
    fun markers() {
        val lines = Utils.readFile("/markers.txt").bufferedReader().readLines()
        lines.map {
//            val split = AocSignal(it).splitBy(4)
            val split = AocSignal(it).splitBy(14)
            var isUniqueCharList = false
            var counter = 0
            while (!isUniqueCharList) {
                counter += 1
                isUniqueCharList = split[counter]!!.allUnique()
            }
//            println("Answer to question #1 is: ${counter + 4}")
            println("Answer to question #1 is: ${counter + 14}")
        }
    }
}
