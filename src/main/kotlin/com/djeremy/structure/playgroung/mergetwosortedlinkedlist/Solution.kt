package com.djeremy.structure.playgroung.mergetwosortedlinkedlist

//Given two sorted linked lists, merge them so that the
// resulting linked list is also sorted.
fun main() {
    while (true) {
        println("First array of integers separated with ' '")
        val arrayOne = readLine()!!.split(' ').map { it.toInt() }.sorted()
        println("Second array of integers separated with ' '")
        val arrayTwo = readLine()!!.split(' ').map { it.toInt() }.sorted()

        var listOne = buildList(arrayOne)
        var listTwo = buildList(arrayTwo)

        var merged: Node<Int>? = merge(listOne, listTwo)
        println("Merged list is: ")
        while (merged != null) {
            print(merged.element.toString() + " ")
            merged = merged.next
        }
        println("\n======")
    }
}

private fun merge(firstList: Node<Int>, secondList: Node<Int>): Node<Int> {
    // compare head elements
    // set lower as head of new list
    // set next as head of extracted element
    // repeat until either of list is empty

    var firstTail: Node<Int>? = firstList
    var secondTail: Node<Int>? = secondList
    val mergedList: Node<Int> = Node(-1)
    var mergedTail: Node<Int> = mergedList

    while (firstTail != null && secondTail != null) {
        if (firstTail.element < secondTail.element) {
            mergedTail.next = firstTail
            mergedTail = firstTail

            firstTail = firstTail.next
        } else {
            mergedTail.next = secondTail
            mergedTail = secondTail

            secondTail = secondTail.next
        }
    }

    if (firstTail != null) {
        mergedTail.next = firstTail
    }

    if (secondTail != null) {
        mergedTail.next = secondTail
    }
    return mergedList.next!!
}

private class Node<E : Comparable<E>>(
    val element: E,
    var next: Node<E>? = null
) : Comparable<Node<E>> {
    override fun compareTo(other: Node<E>): Int = element.compareTo(other.element)
}

private fun buildList(list: List<Int>): Node<Int> {
    var first: Node<Int>? = null
    var next: Node<Int>? = null

    list.forEach {
        when {
            first == null -> {
                first = Node(it)
                next = first
            }
            first === next -> {
                next = Node(it)
                first!!.next = next
            }
            else -> {
                val new = Node(it)
                next!!.next = new
                next = new
            }
        }
    }

    return first!!
}