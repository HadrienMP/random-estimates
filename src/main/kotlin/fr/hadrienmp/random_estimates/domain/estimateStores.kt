package fr.hadrienmp.random_estimates.domain

import java.util.*

class InternationalEstimateStore(private val defaultStore: EstimateStore,
                                 private val estimateStores: Map<Locale, EstimateStore>) {
    fun get(locale: Locale): String {
        val store = estimateStores[locale] ?: defaultStore
        return store.get()
    }
}

interface EstimateStore {
    fun get(): String
}

class DefaultEstimateStore(private val measures: Picker<String>,
                           private val units: Picker<Conjugable>,
                           private val phrases: Picker<String>): EstimateStore {
    override fun get() = phrase(estimate())

    private fun phrase(estimate: String) = phrases.pick().format(estimate)

    private fun estimate(): String {
        val measure = measures.pick()
        val unit = units.pick()
        return measure + " " + unit.conjugate(measure)
    }
}