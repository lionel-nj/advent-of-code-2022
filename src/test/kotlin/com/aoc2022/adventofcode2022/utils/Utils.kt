package com.aoc2022.adventofcode2022.utils

import java.io.InputStream

class Utils {

    companion object {
        fun readFile(filename: String): InputStream = Utils::class.java.getResourceAsStream(filename)!!

        fun Char.getPriority(): Int {
            if (this.isUpperCase()) {
                return 26 + this.lowercaseChar().getPriority()
            }
            return Character.getNumericValue(this) - 9
        }

        fun String.toCharList(): List<Char> {
            return this.toCharArray().toList()
        }
    }
}
