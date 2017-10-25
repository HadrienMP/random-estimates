package fr.hadrienmp.random_estimates.estimates

import java.util.Random

class Random<T>(list: List<T>) {
    companion object {
        private val random = Random()
    }

    constructor(listWrapper: ListWrapper<T>): this(listWrapper.list())

    private val value = list.random()

    fun value() = value

    override fun toString(): String {
        return value().toString()
    }

    private fun List<T>.random(): T {
        if (this.isEmpty()) {
            throw IllegalArgumentException("La liste ne peut pas être vide")
        }
        val position = random.nextInt(this.size)
        return this[position]
    }
}
