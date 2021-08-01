package com.djeremy.structure.playgroung.missingnumber

// You are given an array of positive numbers from 1 to n, such that
// all numbers from 1 to n are present except one number x.
// You have to find x. The input array is not sorted.
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