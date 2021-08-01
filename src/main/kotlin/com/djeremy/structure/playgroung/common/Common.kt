package com.djeremy.structure.playgroung.common

fun isEven(x: Int) = x % 2 == 0

fun calculateSum(n: Int): Int {
    return if (n == 1) 1
    else if (n == 0) 0
    else {
        n + calculateSum(n - 1)
    }
}