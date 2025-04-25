package org.example

class Queue(val capacity: Int) {
    init {
        require(capacity > 0)
    }

    fun length(): Int {
        return 0
    }

}
