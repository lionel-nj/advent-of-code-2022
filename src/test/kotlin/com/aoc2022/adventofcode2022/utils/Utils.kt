package com.aoc2022.adventofcode2022.utils

import java.io.InputStream

class Utils {

    companion object {
        fun readFile(filename: String): InputStream = Utils::class.java.getResourceAsStream(filename)
    }
}
