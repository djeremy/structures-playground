package com.djeremy.structure.playgroung.sumoftwoints

import com.djeremy.structure.playgroung.common.calculateSum
import com.djeremy.structure.playgroung.common.isEven

// Given an array of integers and a value, determine
// if there are any two integers in the array whose
// sum is equal to the given value. Return true if the
// sum exists and return false if it does not
fun main() {
    while (true) {
        println("Provide array of strings separated with ' '")
        val input = readLine()!!.split(' ').map { it.toInt() }
        println("Provide number")
        val value = readLine()!!.toInt()

        val countBy = input.groupingBy { it }.fold(0, { accumulator, _ -> accumulator + 1 })

        var count = 0
        val possiblePairs = hashMapOf<Int, Int>()

        countBy.forEach { (number, occurrence) ->
            val pair = value - number
            if (possiblePairs.containsKey(pair)) {
                count += possiblePairs[pair]!! * occurrence
            } else {
                possiblePairs[number] = occurrence
            }
        }

        if (isEven(value)) {
            val mid = value.div(2)
            count += calculateSum(possiblePairs.getOrDefault(mid, 1) - 1)
        }

        println("Number of occurrences: $count")
    }
}