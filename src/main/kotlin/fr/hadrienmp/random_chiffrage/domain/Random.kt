package fr.hadrienmp.random_chiffrage.domain

import java.util.Random

class Random<T>(private val listWrapper: ListWrapper<T>) {

    private val random = Random()

    override fun toString(): String {
        return listWrapper.random().toString()
    }

    fun ListWrapper<T>.random(): T {
        val position = random.nextInt(this.all().size)
        return this.all()[position]
    }
}
