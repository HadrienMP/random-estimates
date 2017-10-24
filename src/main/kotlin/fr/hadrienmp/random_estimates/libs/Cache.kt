package fr.hadrienmp.random_estimates.libs

import fr.hadrienmp.random_estimates.domain.ListWrapper
import java.time.Duration

class Cache<T>(private val listWrapper: ListWrapper<T>, private val maxAge: Duration): ListWrapper<T> {

    private var lastUpdateTime = now()
    private var cached = listWrapper.all()

    override fun all(): List<T> {
        if (isOutdated()) {
            update()
        }
        return cached
    }

    private fun isOutdated() = now() - lastUpdateTime > maxAge.toMillis()

    private fun update() {
        cached = listWrapper.all()
        lastUpdateTime = now()
    }

    private fun now() = System.currentTimeMillis()
}