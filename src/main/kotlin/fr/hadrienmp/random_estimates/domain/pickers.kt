package fr.hadrienmp.random_estimates.domain

import java.util.*

interface Picker<out T> {
    fun pick(): T
}

class RandomPicker<out T>(private val values: List<T>) : Picker<T> {
    private val random = Random()

    init {
        if (values.isEmpty()) {
            throw IllegalArgumentException("La liste ne peut pas être vide")
        }
    }

    override fun pick(): T {
        val position = random.nextInt(values.size)
        return values[position]
    }
}