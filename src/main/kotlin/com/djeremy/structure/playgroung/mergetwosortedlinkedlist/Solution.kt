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

    var headOne: Node<Int>? = firstList
    var headTwo: Node<Int>? = secondList
    val mergedList: Node<Int> = Node(-1)
    var mergedHead: Node<Int> = mergedList

    while (headOne != null && headTwo != null) {
        if (headOne.element < headTwo.element) {
            mergedHead.next = headOne
            mergedHead = headOne

            headOne = headOne.next
        } else {
            mergedHead.next = headTwo
            mergedHead = headTwo

            headTwo = headTwo.next
        }
    }

    if (headOne != null) {
        mergedHead.next = headOne
    }

    if (headTwo != null) {
        mergedHead.next = headTwo
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