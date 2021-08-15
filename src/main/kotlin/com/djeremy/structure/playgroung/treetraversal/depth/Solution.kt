package com.djeremy.structure.playgroung.treetraversal.depth


fun main() {

    while (true) {
        println("Array of integers separated with ' '")
        val input = readLine()!!.split(' ').map { it.toInt() }.sorted().toTypedArray()

        val treeNode = build(0, input)

        println(treeNode)

        depthFirstTraversal(treeNode)
    }
}


private fun depthFirstTraversal(root: BinaryTreeNode<Int>) {
    val stack: ArrayList<BinaryTreeNode<Int>> = arrayListOf(root)
    while (stack.isNotEmpty()) {
        val currentElement = stack.removeAt(stack.lastIndex)

        print(currentElement.element.toString() + " ")

        currentElement.right?.let { stack.add(it) }
        // left should be added after right, in order to leverage stack's properties
        currentElement.left?.let { stack.add(it) }
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