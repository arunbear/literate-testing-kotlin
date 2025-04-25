package org.example

class Queue<T: Any> (val capacity: Int) {
    private val items = mutableListOf<T>()

    init {
        require(capacity > 0)
    }

    fun length(): Int {
        return items.size
    }

    fun dequeue() : T? {
        return null
    }

    fun enqueue(item: T) {
        items.add(item)
    }

}
