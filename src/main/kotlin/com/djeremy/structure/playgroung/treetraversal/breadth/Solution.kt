package com.djeremy.structure.playgroung.treetraversal.breadth

import com.djeremy.structure.playgroung.common.BinaryTreeNode
import com.djeremy.structure.playgroung.common.build
import java.util.*


fun main() {

    while (true) {
        println("Array of integers separated with ' '")
        val input = readLine()!!.split(' ').map { it.toInt() }.sorted().toTypedArray()

        val treeNode = build(0, input)

        breadthFirstTraversalUsingTwoQueues(treeNode)
    }
}


fun breadthFirstTraversalUsingTwoQueues(root: BinaryTreeNode<Int>): List<Int> {
    val result = mutableListOf<Int>()
    var nextElements: Queue<BinaryTreeNode<Int>> = LinkedList()
    var currentElements: Queue<BinaryTreeNode<Int>> = LinkedList(listOf(root))

    while (currentElements.isNotEmpty()) {
        var swap: Queue<BinaryTreeNode<Int>>?
        while (currentElements.isNotEmpty()) {
            val currentElement = currentElements.remove()

            print(currentElement.element.toString() + " ")
            result.add(currentElement.element)

            currentElement.left?.let { nextElements.add(it) }
            currentElement.right?.let { nextElements.add(it) }
        }

        swap = currentElements
        currentElements = nextElements
        nextElements = swap
        println("------------------")
    }
    return result
}

fun breadthFirstTraversalUsingOneQueue(root: BinaryTreeNode<Int>): List<Int> {
    val result = mutableListOf<Int>()
    var nextElements: Queue<BinaryTreeNode<Int>> = LinkedList(listOf(root))

    while (nextElements.isNotEmpty()) {
        val currentElement = nextElements.remove()

        print(currentElement.element.toString() + " ")
        result.add(currentElement.element)

        currentElement.left?.let { nextElements.add(it) }
        currentElement.right?.let { nextElements.add(it) }

    }
    return result
}