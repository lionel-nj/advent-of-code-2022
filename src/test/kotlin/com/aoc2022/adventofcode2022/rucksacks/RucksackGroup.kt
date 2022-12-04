package com.aoc2022.adventofcode2022.rucksacks

class RucksackGroup(
    private val rucksack1: Rucksack,
    private val rucksack2: Rucksack,
    private val rucksack3: Rucksack
) {
    fun getCommonType(): Char {
        return rucksack1.items.intersect(rucksack2.items)
            .intersect(rucksack1.items.intersect(rucksack3.items)).singleOrNull()!!
    }

    class Rucksack(val items: List<Char>) {
        private val firstCompartment = Compartment(items.subList(0, (items.size + 1) / 2))
        private val secondCompartment = Compartment(items.subList((items.size + 1) / 2, items.size))

        fun getCommonType(): Char? {
            return firstCompartment.items.intersect(secondCompartment.items).singleOrNull()
        }

        private class Compartment(val items: List<Char>)
    }
}
