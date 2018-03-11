package fr.hadrienmp.random_estimates.domain

import java.util.*

interface Picker<out T> {
    fun pick(): T
}

class RandomPicker<out T>(private val values: List<T>) : Picker<T> {
    private val random = Random()

    override fun pick(): T {
        if (values.isEmpty()) {
            throw IllegalArgumentException("La liste ne peut pas être vide")
        }
        val position = random.nextInt(values.size)
        return values[position]
    }
}