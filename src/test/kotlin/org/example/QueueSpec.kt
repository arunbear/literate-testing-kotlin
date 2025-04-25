package org.example

import org.assertj.core.api.BDDAssertions.then
import org.assertj.core.api.BDDAssertions.thenExceptionOfType
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores
import org.junit.jupiter.api.IndicativeSentencesGeneration
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class QueueSpec {
    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores::class)
    inner class A_new_queue {

        @Test
        fun `is empty`() {
            val queue = Queue(1)
            then(queue.length()).isZero()
        }

        @Test
        fun `preserves positive bounding capacity`() {
            val capacity = 3
            val queue = Queue(capacity)
            then(queue.capacity). isEqualTo(capacity)
        }

        @Test
        fun `rejects a zero bounding capacity`() {
            val capacity = 0
            thenExceptionOfType(IllegalArgumentException::class.java). isThrownBy { Queue(capacity) }
        }
    }

}