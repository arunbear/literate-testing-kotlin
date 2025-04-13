package org.example

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

    }

}
