package com.djeremy.structure.playgroung.copylinkedlistwitharbitrarylink

fun main() {

    while (true) {
        println("First array of integers separated with ' '")
        val inputList = readLine()!!.split(' ').map { it.toInt() }.sorted()

        val linkedList = buildList(inputList)

        var copiedList: Node<Int>? = deepCopy(linkedList)

        println("Copied list is: ")
        while (copiedList != null) {
            print(copiedList.element.toString() + " ")
            copiedList = copiedList.next
        }

        println("\n======")
    }
}

private fun deepCopy(list: Node<Int>): Node<Int>? {
    val newNodesByOldOnes: HashMap<Node<Int>, Node<Int>> = hashMapOf()
    var currentHead: Node<Int>? = list
    val first = Node(-1)
    var next = first
    while (currentHead != null) {
        val copied = copy(currentHead, newNodesByOldOnes)
        next.next = copied
        next = copied
        currentHead = currentHead.next
    }
    return first.next
}

private fun copy(node: Node<Int>, newNodesByOldOnes: HashMap<Node<Int>, Node<Int>>): Node<Int> {
    if (newNodesByOldOnes.containsKey(node)) {
        return node
    } else {
        val newNode = Node(node.element)
        newNodesByOldOnes[node] = newNode

        newNode.next = if (node.next == null) {
            node.next
        } else if (newNodesByOldOnes.containsKey(node.next)) {
            newNodesByOldOnes[node.next]
        } else {
            copy(node.next!!, newNodesByOldOnes)
        }

        newNode.arbitraryPointer = if (node.arbitraryPointer == null) {
            null
        } else if (newNodesByOldOnes.containsKey(node.arbitraryPointer)) {
            newNodesByOldOnes[node.arbitraryPointer]
        } else {
            copy(node.arbitraryPointer!!, newNodesByOldOnes)
        }
        return newNode
    }
}

private class Node<E : Comparable<E>>(
    val element: E,
    var next: Node<E>? = null,
    var arbitraryPointer: Node<E>? = null
) : Comparable<Node<E>> {
    override fun compareTo(other: Node<E>): Int = element.compareTo(other.element)
}

private fun buildList(list: List<Int>): Node<Int> {
    var first: Node<Int>? = null
    var next: Node<Int>? = null

    val list = list.map { Node(it) }
    val shuffled = list.shuffled()
    list.zip(shuffled).forEach { (original, shuffled) ->
        original.arbitraryPointer = shuffled
        when {
            first == null -> {
                first = original
                next = first
            }
            first === next -> {
                next = original
                first!!.next = next
            }
            else -> {
                next!!.next = original
                next = original
            }
        }
    }

    return first!!
}