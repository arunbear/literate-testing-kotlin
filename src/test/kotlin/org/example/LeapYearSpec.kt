package org.example

import org.assertj.core.api.BDDAssertions.*
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores
import org.junit.jupiter.api.IndicativeSentencesGeneration
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LeapYearSpec {

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores::class)
    inner class A_year_is_a_leap_year {

        @ParameterizedTest
        @ValueSource(ints = [2004, 1984, 4])
        fun `if it is divisible by 4 but not by 100`(year: Int) {
            then(isALeapYear(year)).isTrue()
        }

        @ParameterizedTest
        @ValueSource(ints = [2000, 1600, 400])
        fun `if it is divisible by 400`(year: Int) {
            then(isALeapYear(year)).isTrue()
        }

    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores::class)
    inner class A_year_is_not_a_leap_year {

        @ParameterizedTest
        @ValueSource(ints = [2022, 2019, 1999, 1])
        fun `if it is not divisible by 4`(year: Int) {
            then(isALeapYear(year)).isFalse()
        }

        @ParameterizedTest
        @ValueSource(ints = [2100, 1900, 100])
        fun `if it is divisible by 100 but not by 400`(year: Int) {
            then(isALeapYear(year)).isFalse()
        }
    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores::class)
    inner class A_year_is_supported {
        @ParameterizedTest
        @ValueSource(ints = [1, Int.MAX_VALUE])
        fun `if it is positive`(year: Int) {
            thenNoException().isThrownBy { isALeapYear(year) }
        }
    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores::class)
    inner class A_year_is_not_supported {
        @Test
        fun `if it is zero`() {
            thenExceptionOfType(IllegalArgumentException::class.java).isThrownBy { isALeapYear(0) }
        }

        @ParameterizedTest
        @ValueSource(ints = [-1, -4, -100, -400, Int.MIN_VALUE])
        fun `if it is negative`(year: Int) {
            thenExceptionOfType(IllegalArgumentException::class.java).isThrownBy { isALeapYear(year) }
        }
    }

}
