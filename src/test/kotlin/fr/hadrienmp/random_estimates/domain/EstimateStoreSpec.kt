package fr.hadrienmp.random_estimates.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class EstimateStoreSpec {

    @Test fun `should conjugate phrases, measures and units for a phrased estimate`() {
        val estimateStore = DefaultEstimateStore(
                SingleElement("3"),
                SingleElement(RegularWord("Day")),
                SingleElement("It will take %s probably"))

        val estimate = estimateStore.get()

        assertThat(estimate).isEqualTo("It will take 3 Days probably")
    }

    class SingleElement<T>(private val element: T): Picker<T> {
        override fun pick() = element
    }
}
