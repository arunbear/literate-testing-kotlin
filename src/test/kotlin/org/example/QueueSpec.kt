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
            val queue = Queue<Int>(1)
            then(queue.length()).isZero()
        }

        @Test
        fun `preserves positive bounding capacity`() {
            val capacity = 3
            val queue = Queue<Int>(capacity)
            then(queue.capacity). isEqualTo(capacity)
        }

        @Test
        fun `rejects a zero bounding capacity`() {
            val capacity = 0
            thenExceptionOfType(IllegalArgumentException::class.java). isThrownBy { Queue<Int>(capacity) }
        }
    }

    @Nested
    inner class An_empty_queue {
        @Test
        fun `dequeues a null`() {
            val queue = Queue<Int>(1)
            then( queue.dequeue() ) .isNull()
        }

        @Test
        fun `becomes non empty when value enqueued`() {
            val queue = Queue<String>(1)
            queue.enqueue("rock")
            then(queue.length()). isEqualTo(1)
        }

    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores::class)
    inner class A_non_empty_queue {

        @Nested
        inner class that_is_not_full {

            @Test
            fun `becomes longer when a value is enqueued`() {
                // given ...
                val queue = Queue<String>(2)
                queue.enqueue("rock")
                val lengthBefore = queue.length()

                // when ...
                queue.enqueue("paper")

                // then ...
                then(queue.length()). isGreaterThan(lengthBefore)
            }

            @Test
            fun `becomes full when enqueued up to capacity`() {
                // given ...
                val queue = Queue<String>(2)
                queue.enqueue("rock")

                // when ...
                queue.enqueue("paper")

                // then ...
                then(queue.length()). isEqualTo(queue.capacity)
            }

        }

        @Nested
        inner class that_is_full {

            @Test
            fun `ignores further enqueued values`() {
                // given ...
                val queue = Queue<String>(1)
                val rock = "rock"
                queue.enqueue(rock)

                // when ...
                queue.enqueue("paper")

                // then ...
                then(queue.length()).  isEqualTo(1)
                then(queue.dequeue()). isEqualTo(rock)
            }

            @Test
            fun `becomes non full when dequeued`() {
                // given ...
                val queue = Queue<String>(2)
                queue.enqueue("rock")
                queue.enqueue("paper")

                // when ...
                queue.dequeue()

                // then ...
                then(queue.length()). isLessThan(queue.capacity)
            }

            @Test
            fun `dequeues values in order enqueued`() {
                // given ...
                val queue = Queue<String>(2)
                val rock = "rock"
                val paper = "paper"

                queue.enqueue(rock)
                queue.enqueue(paper)

                // when / then ...
                then(queue.dequeue()). isEqualTo(rock)
                then(queue.dequeue()). isEqualTo(paper)
            }

        }

        @Test
        fun `dequeues values in order enqueued`() {
            // given ...
            val queue = Queue<String>(2)
            val rock = "rock"
            val paper = "paper"

            queue.enqueue(rock)
            queue.enqueue(paper)

            // when / then ...
            then(queue.dequeue()). isEqualTo(rock)
            then(queue.dequeue()). isEqualTo(paper)
        }

        @Test
        fun `becomes shorter when dequeued`() {
            // given ...
            val queue = Queue<String>(1)

            queue.enqueue("rock")
            val lengthBefore = queue.length()

            // when ...
            queue.dequeue()

            then(queue.length()).isLessThan(lengthBefore)
        }

    }
}
