package org.example.org.example

class Stack<T> {
    fun depth(): Int {
        return 0
    }

    fun top() {
        check(depth() > 0)
    }

}
