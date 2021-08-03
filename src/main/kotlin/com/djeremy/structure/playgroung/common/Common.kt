package com.djeremy.structure.playgroung.common

fun isEven(x: Int) = x % 2 == 0

fun calculateSum(n: Int): Int {
    return when (n) {
        1 -> 1
        0 -> 0
        else -> {
            n + calculateSum(n - 1)
        }
    }
}