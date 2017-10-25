package fr.hadrienmp.random_estimates.data_sources

import fr.hadrienmp.random_estimates.estimates.ListWrapper
import java.time.Duration

class Cache<T>(private val listWrapper: ListWrapper<T>, private val maxAge: Duration): ListWrapper<T> {

    private var lastUpdateTime = now()
    private var cached = listWrapper.list()

    override fun list(): List<T> {
        if (isOutdated()) {
            update()
        }
        return cached
    }

    private fun isOutdated() = now() - lastUpdateTime > maxAge.toMillis()

    private fun update() {
        cached = listWrapper.list()
        lastUpdateTime = now()
    }

    private fun now() = System.currentTimeMillis()
}