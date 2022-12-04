package com.aoc2022.adventofcode2022.rps

class Round(private val opponentMove: GameOption, private val myMove: GameOption) {

    fun getScore(): Int {
        // it's a draw
        if (opponentMove.getScore() == myMove.getScore()) {
            return myMove.getScore() + 3
        } else {
            // I win
            if (myMove.winsBefore() == opponentMove) {
                return myMove.getScore() + 6
            } else {
                // I loose
                return myMove.getScore()
            }
        }
    }
}
