package com.aoc2022.adventofcode2022.supplystacks

open class Arrangement protected constructor(private val stacks: Map<Int, AocStack>) {

    fun popAllFirst(): List<Char> {
        return stacks.toSortedMap().values.map { it.first() }
    }

    class AocStack(private val crates: ArrayDeque<Char>) {

        fun addAllInOrder(other: AocStack) {
            other.crates.forEach {
                this.crates.addFirst(it)
            }
        }

        fun addLast(char: Char) {
            crates.addLast(char)
        }

        fun addFirst(char: Char) {
            crates.addFirst(char)
        }

        fun removeFirst(): Char {
            return crates.removeFirst()
        }

        fun first(): Char {
            return crates.first()
        }

        companion object {
            fun create(char: Char): AocStack {
                val deque = ArrayDeque<Char>()
                deque.addLast(char)
                return AocStack(deque)
            }

            fun createEmpty(): AocStack {
                return AocStack(ArrayDeque())
            }
        }
    }
}

class Arrangement9000(private val stacks: Map<Int, AocStack>) : Arrangement(stacks) {
    fun apply(procedure: Procedure): Arrangement9000 {
        (0 until procedure.count).forEach { _ ->
            stacks[procedure.to]!!.addFirst(
                stacks[procedure.from]!!.removeFirst()
            )
        }
        return Arrangement9000(stacks)
    }

    class Builder {
        private val stacks = emptyMap<Int, AocStack>().toMutableMap()

        fun add(stackIndex: Int, char: Char): Builder {
            if (stacks.containsKey(stackIndex)) {
                stacks[stackIndex]!!.addLast(char)
            } else {
                stacks[stackIndex] = AocStack.create(char)
            }
            return this
        }

        fun build(): Arrangement9000 {
            return Arrangement9000(stacks)
        }
    }
}

class Arrangement9001(private val stacks: Map<Int, AocStack>) : Arrangement(stacks) {
    fun apply(procedure: Procedure): Arrangement9001 {
        val tmp = AocStack.createEmpty()
        (0 until procedure.count).forEach { _ ->
            tmp.addFirst(
                stacks[procedure.from]!!.removeFirst()
            )
        }
        stacks[procedure.to]!!.addAllInOrder(tmp)
        return Arrangement9001(stacks)
    }

    class Builder {
        private val stacks = emptyMap<Int, AocStack>().toMutableMap()

        fun add(stackIndex: Int, char: Char): Builder {
            if (stacks.containsKey(stackIndex)) {
                stacks[stackIndex]!!.addLast(char)
            } else {
                stacks[stackIndex] = AocStack.create(char)
            }
            return this
        }

        fun build(): Arrangement9001 {
            return Arrangement9001(stacks)
        }
    }
}
