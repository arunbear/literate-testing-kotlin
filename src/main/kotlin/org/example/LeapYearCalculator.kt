package org.example

fun isALeapYear(year: Int): Boolean {
    return year % 4 == 0 && year % 100 != 0
}