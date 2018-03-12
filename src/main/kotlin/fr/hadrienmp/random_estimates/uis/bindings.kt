package fr.hadrienmp.random_estimates.uis

import fr.hadrienmp.random_estimates.domain.DefaultEstimateStore
import fr.hadrienmp.random_estimates.domain.EstimateStore
import fr.hadrienmp.random_estimates.domain.InternationalEstimateStore
import fr.hadrienmp.random_estimates.domain.RandomPicker
import fr.hadrienmp.random_estimates.lib.JsonLanguage
import fr.hadrienmp.random_estimates.lib.LanguageFile
import fr.hadrienmp.random_estimates.lib.languageFiles
import java.util.*

val estimateStores = estimateStores()
val internationalEstimateStore = internationalEstimateStore(estimateStores)

fun internationalEstimateStore(estimateStores: Map<Locale, EstimateStore>): InternationalEstimateStore {
    return InternationalEstimateStore(estimateStores[Locale.ENGLISH]!!, estimateStores)
}

private fun estimateStores(): Map<Locale, EstimateStore> {
    val languageFilePaths = languageFiles()
    return languageFilePaths
            .map { LanguageFile(it) }
            .map { Pair(it.locale, estimateStore(it.content)) }
            .toMap()
}

private fun estimateStore(json: String): EstimateStore {
    val jsonLanguage = JsonLanguage(json)
    return DefaultEstimateStore(
            RandomPicker(jsonLanguage.measures()),
            RandomPicker(jsonLanguage.units()),
            RandomPicker(jsonLanguage.phrases())
    )
}