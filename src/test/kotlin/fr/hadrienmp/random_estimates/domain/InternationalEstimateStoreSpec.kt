package fr.hadrienmp.random_estimates.domain

import org.assertj.core.api.Assertions
import org.junit.Test
import java.util.*

class InternationalEstimateStoreSpec {
    @Test
    fun `should use the store matching the requested locale`() {
        val frenchEstimateStore = FakeEstimateStore("in french")
        val estimateStores = mapOf<Locale, EstimateStore>(
                Pair(Locale.FRENCH, frenchEstimateStore),
                Pair(Locale.ENGLISH, FakeEstimateStore("in english")),
                Pair(Locale.JAPANESE, FakeEstimateStore("nihon no")))
        val internationalEstimateStore = InternationalEstimateStore(frenchEstimateStore, estimateStores)

        val estimate = internationalEstimateStore.get(Locale.JAPANESE)

        Assertions.assertThat(estimate).isEqualTo("nihon no")
    }

    @Test
    fun `should use the store matching the requested locale language even with a different country`() {
        val frenchEstimateStore = FakeEstimateStore("in french")
        val estimateStores = mapOf<Locale, EstimateStore>(
                Pair(Locale.FRENCH, frenchEstimateStore),
                Pair(Locale.ENGLISH, FakeEstimateStore("in english")),
                Pair(Locale.JAPANESE, FakeEstimateStore("nihon no")))
        val internationalEstimateStore = InternationalEstimateStore(frenchEstimateStore, estimateStores)

        val estimate = internationalEstimateStore.get(Locale.JAPAN)

        Assertions.assertThat(estimate).isEqualTo("nihon no")
    }

    @Test
    fun `should use the default store when the locale is not known`() {
        val frenchEstimateStore = FakeEstimateStore("in french")
        val estimateStores = mapOf<Locale, EstimateStore>(Pair(Locale.FRENCH, frenchEstimateStore))
        val internationalEstimateStore = InternationalEstimateStore(frenchEstimateStore, estimateStores)

        val estimate = internationalEstimateStore.get(Locale.JAPANESE)

        Assertions.assertThat(estimate).isEqualTo("in french")
    }

    class FakeEstimateStore(private val estimate: String): EstimateStore {
        override fun get() = estimate
    }
}
