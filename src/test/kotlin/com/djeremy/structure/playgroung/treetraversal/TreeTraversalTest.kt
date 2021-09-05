package com.djeremy.structure.playgroung.treetraversal

import com.djeremy.structure.playgroung.common.build
import com.djeremy.structure.playgroung.treetraversal.breadth.breadthFirstTraversalUsingOneQueue
import com.djeremy.structure.playgroung.treetraversal.breadth.breadthFirstTraversalUsingTwoQueues
import com.djeremy.structure.playgroung.treetraversal.depth.depthFirstTraversalInOrder
import com.djeremy.structure.playgroung.treetraversal.depth.depthFirstTraversalPostOrder
import com.djeremy.structure.playgroung.treetraversal.depth.depthFirstTraversalPreOrder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Tree traversal test")
class TreeTraversalTest {

    @Nested
    @DisplayName("Breadth first tree traversal")
    @IndicativeSentencesGeneration(separator = " -> ")
    inner class BreadthFirstTraversalTest {
        @Test
        @DisplayName("Using two queues")
        fun test_traversal_two_lists() {
            // given
            val inputArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
            val root = build(0, inputArray)

            // when
            val result = breadthFirstTraversalUsingTwoQueues(root)

            // then
            assertThat(result)
                .containsExactly(1, 2, 3, 4, 5, 6, 7, 8)
        }

        @Test
        @DisplayName("Using one queue")
        fun test_traversal_one_list() {
            // given
            val inputArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
            val root = build(0, inputArray)

            // when
            val result = breadthFirstTraversalUsingOneQueue(root)

            // then
            assertThat(result)
                .containsExactly(1, 2, 3, 4, 5, 6, 7, 8)
        }
    }

    @Nested
    @DisplayName("Depth first tree traversal")
    @IndicativeSentencesGeneration(separator = " -> ")
    inner class DepthFirstTraversalTest {

        @Test
        @DisplayName("Using pro-order method")
        fun test_preorder_traversal() {
            // given
            val inputArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
            val root = build(0, inputArray)

            // when
            val result = depthFirstTraversalPreOrder(root)

            // then
            assertThat(result).containsExactly(
                1, 2, 4, 8, 5, 3, 6, 7
            )

        }

        @Test
        @DisplayName("Using in-order method")
        fun test_inorder_traversal() {
            // given
            val inputArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
            val root = build(0, inputArray)
            // when
            val result = depthFirstTraversalInOrder(root)

            // then
            assertThat(result)
                .containsExactly(
                    8, 4, 2, 5, 1, 6, 3, 7
                )

        }

        @Test
        @DisplayName("Using post-order method")
        fun test_postorder_traversal() {
            // given
            val inputArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
            val root = build(0, inputArray)
            // when
            val result = depthFirstTraversalPostOrder(root)

            // then
            assertThat(result)
                .containsExactly(
                    8, 4, 5, 2, 6, 7, 3, 1
                )

        }
    }

}