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
        return if (items.isEmpty()) null
        else items.removeLast()
    }

    fun enqueue(item: T) {
        if (items.size < capacity) {
            items.add(item)
        }
    }

}
