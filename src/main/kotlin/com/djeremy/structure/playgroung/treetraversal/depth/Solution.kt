package com.djeremy.structure.playgroung.treetraversal.depth

import com.djeremy.structure.playgroung.common.BinaryTreeNode
import com.djeremy.structure.playgroung.common.build


fun main() {

    while (true) {
        println("Array of integers separated with ' '")
        val input = readLine()!!.split(' ').map { it.toInt() }.sorted().toTypedArray()

        val treeNode = build(0, input)

        depthFirstTraversalPreOrder(treeNode)
        depthFirstTraversalInOrder(treeNode)
    }
}


// Access the data part of the current node (in the figure: position red).
// Traverse the left subtree by recursively calling the pre-order function.
// Traverse the right subtree by recursively calling the pre-order function.
fun depthFirstTraversalPreOrder(root: BinaryTreeNode<Int>): List<Int> {
    val stack: ArrayList<BinaryTreeNode<Int>> = arrayListOf(root)
    val result = mutableListOf<Int>()

    while (stack.isNotEmpty()) {
        val currentElement = stack.removeAt(stack.lastIndex)

        print(currentElement.element.toString() + " ")
        result.add(currentElement.element)

        currentElement.right?.let { stack.add(it) }
        // left should be added after right, in order to leverage stack's properties
        currentElement.left?.let { stack.add(it) }
    }
    return result
}

// Traverse the left subtree by recursively calling the in-order function.
// Access the data part of the current node (in the figure: position green).
// Traverse the right subtree by recursively calling the in-order function.
fun depthFirstTraversalInOrder(root: BinaryTreeNode<Int>): List<Int> {
    val result = mutableListOf<Int>()
    val stack: ArrayList<BinaryTreeNode<Int>> = arrayListOf(root)

    var currentElement: BinaryTreeNode<Int>? = root.left

    while (stack.isNotEmpty() || currentElement != null) {
        if (currentElement != null) {
            stack.add(currentElement)
            currentElement = currentElement.left
        } else {
            val visit = stack.removeAt(stack.lastIndex)
            print(visit.element.toString() + " ")
            currentElement = visit.right

            result.add(visit.element)
        }
    }
    return result
}

//Traverse the left subtree by recursively calling the post-order function.
//Traverse the right subtree by recursively calling the post-order function.
//Access the data part of the current node (in the figure: position blue).
fun depthFirstTraversalPostOrder(root: BinaryTreeNode<Int>): List<Int> {
    val result = mutableListOf<Int>()

    val stack: ArrayList<BinaryTreeNode<Int>> = arrayListOf()
    var nextElement: BinaryTreeNode<Int>? = root
    var lastVisitedElement: BinaryTreeNode<Int>? = root

    while (stack.isNotEmpty() || nextElement != null) {

        if (nextElement != null) {
            stack.add(nextElement)
            nextElement = nextElement.left
        } else {
            val currentElement = stack.last()

            if (currentElement.right != null && currentElement.right != lastVisitedElement) {
                nextElement = currentElement.right
            } else {
                print(currentElement.element.toString() + " ")
                result.add(currentElement.element)
                lastVisitedElement = currentElement
                stack.removeLast()
            }
        }
    }
    return result
}

