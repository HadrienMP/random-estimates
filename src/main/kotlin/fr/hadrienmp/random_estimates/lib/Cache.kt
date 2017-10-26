package fr.hadrienmp.random_estimates.lib

import fr.hadrienmp.random_estimates.domain.ListProvider
import java.time.Duration

class Cache<out T>(private val listProvider: ListProvider<T>, private val maxAge: Duration): ListProvider<T> {

    private var lastUpdateTime = now()
    private var cached = listProvider.get()

    override fun get(): List<T> {
        if (isOutdated()) {
            update()
        }
        return cached
    }

    private fun isOutdated() = now() - lastUpdateTime > maxAge.toMillis()

    private fun update() {
        cached = listProvider.get()
        lastUpdateTime = now()
    }

    private fun now() = System.currentTimeMillis()
}