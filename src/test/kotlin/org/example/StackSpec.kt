package org.example

import org.assertj.core.api.BDDAssertions.then
import org.assertj.core.api.BDDAssertions.thenExceptionOfType
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores
import org.junit.jupiter.api.IndicativeSentencesGeneration
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class StackSpec {

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores::class)
    inner class A_new_stack {
        @Test
        fun `is empty`() {
            val stack = Stack<Int>()
            then(stack.depth()).isZero()
        }
    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores::class)
    inner class An_empty_stack {

        @Test
        fun `throws when queried for its top item`() {
            val stack = Stack<Int>()
            thenExceptionOfType(IllegalStateException::class.java).isThrownBy {
                stack.top()
            }
        }

        @Test
        fun `throws when popped`() {
            val stack = Stack<Int>()
            thenExceptionOfType(IllegalStateException::class.java).isThrownBy {
                stack.pop()
            }
        }

        @Test
        fun `acquires depth by retaining a pushed item as its top`() {
            val stack = Stack<String>()
            val item = "rock"

            stack.push(item)

            then(stack.depth()).isEqualTo(1)
            then(stack.top()).isEqualTo(item)
        }

    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores::class)
    inner class A_non_empty_stack {

        @Test
        fun `becomes deeper by retaining a pushed item as its top`() {
            // given ->
            val stack = Stack<String>()
            stack.push("paper")

            val item = "rock"

            // when ->
            stack.push(item)

            // then ->
            then(stack.depth()).isEqualTo(2)
            then(stack.top()).isEqualTo(item)
        }

        @Test
        fun `on popping reveals tops in reverse order of pushing`() {
            // given ...
            val stack = Stack<String>()
            val rock     = "rock"
            val paper    = "paper"
            val scissors = "scissors"

            with(stack) {
                push(rock)
                push(paper)
                push(scissors)

                // when ...
                pop()
                then(top()).isEqualTo(paper)

                pop()
                then(top()).isEqualTo(rock)
            }
        }

    }
}