package com.aoc2022.adventofcode2022.supplystacks

import com.aoc2022.adventofcode2022.utils.Utils
import com.aoc2022.adventofcode2022.utils.Utils.Companion.toCharList
import org.junit.jupiter.api.Test

class FixShip {

    @Test
    fun arrangeShip() {
        val cratePattern = """\[[A-Z]]""".toRegex()
        val lines = Utils.readFile("/procedures.txt").bufferedReader().readLines()

        val arrangementBuilder9000 = Arrangement9000.Builder()
        val arrangementBuilder9001 = Arrangement9001.Builder()

        val procedures = lines.mapNotNull {
            if (it.startsWith("move")) {
                Procedure(
                    it.split(" ")[1].toInt(),
                    it.split(" ")[3].toInt(),
                    it.split(" ")[5].toInt()
                )
            } else {
                cratePattern.findAll(it).iterator().forEachRemaining {
                    val n = (it.range.first + 1 + 3) / 4
                    arrangementBuilder9000.add(n, it.groupValues[0].toCharList()[1])
                    arrangementBuilder9001.add(n, it.groupValues[0].toCharList()[1])
                }
                null
            }
        }
        val arrangement9000 = arrangementBuilder9000.build()
        val arrangement9001 = arrangementBuilder9001.build()
        procedures.forEach { procedure ->
            arrangement9000.apply(procedure)
            arrangement9001.apply(procedure)
        }
        println("Answer to question #1 is: ${arrangement9000.popAllFirst().joinToString("")}")
        println("Answer to question #2 is: ${arrangement9001.popAllFirst().joinToString("")}")
    }
}
