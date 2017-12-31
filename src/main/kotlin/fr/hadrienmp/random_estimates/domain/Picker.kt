package fr.hadrienmp.random_estimates.domain

import fr.hadrienmp.random_estimates.lib.ListProvider
import java.util.*

interface Picker<out T> {
    fun pick(): T
}

class RandomPicker<out T>(listProvider: ListProvider<T>) : Picker<T> {
    private val random = Random()
    private val list = listProvider.get()

    override fun pick(): T {
        if (list.isEmpty()) {
            throw IllegalArgumentException("La liste ne peut pas être vide")
        }
        val position = random.nextInt(list.size)
        return list[position]
    }
}