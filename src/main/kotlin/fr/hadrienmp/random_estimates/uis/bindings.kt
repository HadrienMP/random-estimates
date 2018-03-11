package fr.hadrienmp.random_estimates.uis

import fr.hadrienmp.random_estimates.domain.*
import fr.hadrienmp.random_estimates.lib.JsonLanguage
import fr.hadrienmp.random_estimates.lib.LanguageFile
import fr.hadrienmp.random_estimates.lib.languageFilePaths
import java.util.*

fun internationalEstimateStore(): InternationalEstimateStore {
    val estimateStores = estimateStores()
    return InternationalEstimateStore(
            estimateStores[Locale.ENGLISH]!!,
            estimateStores)
}

private fun estimateStores() = languageFilePaths()
        .map { LanguageFile(it) }
        .map { Pair(it.locale, estimateStore(it.content())) }
        .toMap()

private fun estimateStore(json: String): DefaultEstimateStore {
    val jsonLanguage = JsonLanguage(json)
    return DefaultEstimateStore(
            RandomPicker(jsonLanguage.measures()),
            RandomPicker(jsonLanguage.units()),
            RandomPicker(jsonLanguage.phrases())
    )
}