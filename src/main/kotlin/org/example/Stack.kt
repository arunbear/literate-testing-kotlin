package org.example

class Stack<T : Any>() {
    private val items = mutableListOf<T>()

    fun depth(): Int {
        return items.size
    }

    fun top(): T {
        check(depth() > 0)
        return items.last()
    }

    fun pop() {
        check(depth() > 0)
    }

    fun push(item: T) {
        items.add(item)
    }

}
