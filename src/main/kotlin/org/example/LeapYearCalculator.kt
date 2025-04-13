package org.example

fun isALeapYear(year: Int): Boolean {
    return year % 5 == 0 && year % 100 != 0
}