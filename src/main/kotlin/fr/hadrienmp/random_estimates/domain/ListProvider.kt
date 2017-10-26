package fr.hadrienmp.random_estimates.domain

interface ListProvider<out T> {
    fun get(): List<T>
}