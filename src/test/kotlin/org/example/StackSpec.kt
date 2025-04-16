package org.example

import org.assertj.core.api.BDDAssertions.then
import org.assertj.core.api.BDDAssertions.thenExceptionOfType
import org.example.org.example.Stack
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

    }
}