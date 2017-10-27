package fr.hadrienmp.random_estimates.lib

interface ListProvider<out T> {
    fun get(): List<T>
}