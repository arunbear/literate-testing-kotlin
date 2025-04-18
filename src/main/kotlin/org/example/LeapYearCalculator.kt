package org.example

fun isALeapYear(year: Int): Boolean {
    require(year > 0)

    return when {
        year % 4 == 0 && year % 100 != 0 -> true
        year % 400 == 0 -> true
        else -> false
    }
}