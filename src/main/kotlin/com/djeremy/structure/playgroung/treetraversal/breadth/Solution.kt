package com.djeremy.structure.playgroung.treetraversal.breadth

import com.djeremy.structure.playgroung.common.BinaryTreeNode
import com.djeremy.structure.playgroung.common.build


fun main() {

    while (true) {
        println("Array of integers separated with ' '")
        val input = readLine()!!.split(' ').map { it.toInt() }.sorted().toTypedArray()

        val treeNode = build(0, input)

        depthFirstTraversal(treeNode)
    }
}

fun depthFirstTraversal(root: BinaryTreeNode<Int>) {
    val stack: ArrayList<BinaryTreeNode<Int>> = arrayListOf(root)
    while (stack.isNotEmpty()) {
        val currentElement = stack.removeAt(stack.lastIndex)

        print(currentElement.element.toString() + " ")

        currentElement.right?.let { stack.add(it) }
        // left should be added after right, in order to leverage stack's properties
        currentElement.left?.let { stack.add(it) }
    }
}

