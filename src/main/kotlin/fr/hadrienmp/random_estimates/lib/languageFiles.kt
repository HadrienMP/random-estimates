package fr.hadrienmp.random_estimates.lib

import com.google.gson.Gson
import fr.hadrienmp.random_estimates.domain.RegularWord
import java.util.*

fun languageFiles() = classPathFolders.filesIn("data")

class LanguageFile(file: File) {
    val content = file.content()
    val locale = localeOf(file)

    private fun localeOf(file: File): Locale {
        val languageTag = Regex("([a-z]+)\\.json")
                .find(file.path())
                ?.groups
                ?.get(1)
                ?.value
                ?: throw IllegalArgumentException("The file name does not look like a json language file")
        return Locale(languageTag)
    }
}

class JsonLanguage(json: String) {
    private val language: Language = Gson().fromJson(json, Language::class.java) ?: Language()

    fun measures() = language.measures
    fun units() = language.units.map { RegularWord(it) }
    fun phrases() = language.phrases
}

private data class Language(val measures: List<String>,
                    val units: List<String>,
                    val phrases: List<String>) {
    constructor() : this(emptyList(), emptyList(), emptyList())
}