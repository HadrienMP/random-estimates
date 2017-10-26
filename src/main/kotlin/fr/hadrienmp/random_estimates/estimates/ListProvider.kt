package fr.hadrienmp.random_estimates.estimates

interface ListProvider<out T> {
    fun get(): List<T>
}