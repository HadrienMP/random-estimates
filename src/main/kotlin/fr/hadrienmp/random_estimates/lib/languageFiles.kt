package fr.hadrienmp.random_estimates.lib

import com.google.gson.Gson
import fr.hadrienmp.random_estimates.domain.RegularWord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.lang.Thread.*
import java.util.*

val log: Logger = LoggerFactory.getLogger("Language Files")

fun languageFilePaths(): List<File> {
    val languageFilesDirectoryName = "data"
    val languageFilesDirectoryPath = ClassLoader.getSystemResource(languageFilesDirectoryName)
            .path
    log.info(languageFilesDirectoryPath)
    return File(languageFilesDirectoryPath)
            .listFiles()
            .toList()
}

class LanguageFile(private val file: File) {
    fun content() = file.readText()

    val locale: Locale
    init {
        if (!file.exists()) throw IllegalArgumentException("The provided file does not exist")
        val languageTag = Regex("([a-z]+)\\.json")
                .find(file.name)
                ?.groups
                ?.get(1)
                ?.value
                ?: throw IllegalArgumentException("The file name does not look like a json language file")
        locale = Locale(languageTag)
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