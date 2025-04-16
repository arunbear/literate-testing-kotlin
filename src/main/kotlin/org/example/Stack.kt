package org.example

class Stack<T> {
    fun depth(): Int {
        return 0
    }

    fun top() {
        check(depth() > 0)
    }

    fun pop() {
        check(depth() > 0)
    }

}
