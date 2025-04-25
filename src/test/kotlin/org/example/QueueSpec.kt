package org.example

import org.assertj.core.api.BDDAssertions.then
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
    }

}