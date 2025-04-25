package org.example

class Queue<T: Any> (val capacity: Int) {
    init {
        require(capacity > 0)
    }

    fun length(): Int {
        return 0
    }

    fun dequeue() : T? {
        return null
    }

}
