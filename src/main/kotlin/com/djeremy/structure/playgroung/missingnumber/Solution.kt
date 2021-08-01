package com.djeremy.structure.playgroung.missingnumber

fun main() {

    while (true) {
        val input = readLine()!!.split(' ').map { it.toInt() }

        val expectedSum = calculateSum(input.size + 1)
        val actualValue = input.sum()

        val missingNumber = expectedSum - actualValue
        println(missingNumber)
    }
}

fun calculateSum(n: Int): Int {
    return if (n == 1) {
        1
    } else {
        n + calculateSum(n - 1)
    }
}