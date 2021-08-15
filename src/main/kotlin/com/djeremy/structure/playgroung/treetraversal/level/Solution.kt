package com.djeremy.structure.playgroung.treetraversal.level

import java.util.*


fun main() {

    while (true) {
        println("Array of integers separated with ' '")
        val input = readLine()!!.split(' ').map { it.toInt() }.sorted().toTypedArray()

        val treeNode = build(0, input)

        println(treeNode)

        levelFirstTraversal(treeNode)
    }
}


private fun levelFirstTraversal(root: BinaryTreeNode<Int>) {

    var nextElements: Queue<BinaryTreeNode<Int>> = LinkedList()
    var currentElements: Queue<BinaryTreeNode<Int>> = LinkedList(listOf(root))

    while (currentElements.isNotEmpty()) {
        var swap: Queue<BinaryTreeNode<Int>>? = null
        while (currentElements.isNotEmpty()) {
            val currentElement = currentElements.remove()

            print(currentElement.element.toString() + " ")

            currentElement.left?.let { nextElements.add(it) }
            currentElement.right?.let { nextElements.add(it) }
        }

        swap = currentElements
        currentElements = nextElements
        nextElements = swap
        println("------------------")
    }
}

private fun build(currentIndex: Int, array: Array<Int>): BinaryTreeNode<Int> {
    val node: BinaryTreeNode<Int> = BinaryTreeNode(array[currentIndex])

    val leftIndex = (currentIndex * 2) + 1
    val rightIndex = (currentIndex * 2) + 2

    if (leftIndex < array.size) {
        node.left = build(leftIndex, array)
    }
    if (rightIndex < array.size) {
        node.right = build(rightIndex, array)
    }
    return node
}

private class BinaryTreeNode<T>(
    val element: T,
    var left: BinaryTreeNode<T>? = null,
    var right: BinaryTreeNode<T>? = null
)