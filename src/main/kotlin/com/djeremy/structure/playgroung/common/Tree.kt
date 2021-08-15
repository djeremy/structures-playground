package com.djeremy.structure.playgroung.common

fun build(currentIndex: Int, array: Array<Int>): BinaryTreeNode<Int> {
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

class BinaryTreeNode<T>(
    val element: T,
    var left: BinaryTreeNode<T>? = null,
    var right: BinaryTreeNode<T>? = null
)