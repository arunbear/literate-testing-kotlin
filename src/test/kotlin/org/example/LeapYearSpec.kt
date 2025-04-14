package org.example

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores
import org.junit.jupiter.api.IndicativeSentencesGeneration
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LeapYearSpec {

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores::class)
    inner class A_year_is_a_leap_year {

        @ParameterizedTest
        @ValueSource(ints = [2004, 1984, 4])
        fun if_it_is_divisible_by_4_but_not_by_100(year: Int) {
            assertThat(isALeapYear(year)).isTrue()
        }

        @ParameterizedTest
        @ValueSource(ints = [2000, 1600, 400])
        fun if_it_is_divisible_by_400(year: Int) {
            assertThat(isALeapYear(year)).isTrue()
        }

    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores::class)
    inner class A_year_is_not_a_leap_year {

        @ParameterizedTest
        @ValueSource(ints = [2022, 2019, 1999, 1])
        fun if_it_is_not_divisible_by_4(year: Int) {
            assertThat(isALeapYear(year)).isFalse()
        }

        @ParameterizedTest
        @ValueSource(ints = [2100, 1900, 100])
        fun if_it_is_divisible_by_100_but_not_by_400(year: Int) {
            assertThat(isALeapYear(year)).isFalse()
        }
    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores::class)
    inner class A_year_is_supported {
        @ParameterizedTest
        @ValueSource(ints = [1, Int.MAX_VALUE])
        fun if_it_is_positive(year: Int) {
            Assertions.assertThatNoException()
                .isThrownBy { isALeapYear(year) }
        }
    }

}
