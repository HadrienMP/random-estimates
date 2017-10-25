package fr.hadrienmp.random_estimates.data_sources

import fr.hadrienmp.random_estimates.estimates.ListWrapper
import org.junit.Test
import org.mockito.Mockito.*
import java.time.Duration

class CacheSpec {
    private val listWrapper = mock(ListWrapper::class.java) as ListWrapper<String>

    @Test fun `should delegate the calls to its source`() {
        Cache(listWrapper, Duration.ofMinutes(1))
        verify(listWrapper).list()
    }

    @Test fun `should call the source when the cache is older that its time to live`() {
        val cache = Cache(listWrapper, Duration.ofMinutes(0))

        cache.list()

        verify(listWrapper, times(2)).list()
    }

    @Test fun `should not call the source when the cache is younger that its time to live`() {
        val cache = Cache(listWrapper, Duration.ofMinutes(1))

        cache.list()

        verify(listWrapper).list()
    }

    @Test fun `should not call the source when the cache has been recently refreshed`() {
        val cache = Cache(listWrapper, Duration.ofMillis(100))

        Thread.sleep(110)
        cache.list()
        cache.list()

        verify(listWrapper, times(2)).list()
    }
}

