package fr.hadrienmp.random_estimates.lib

interface Folders {
    fun filesIn(path: String): List<File>
}

val classPathFolders = classPathFolders()

fun classPathFolders(sourceCode: SourceCode = SourceCode()) = when {
    sourceCode.isInJar() -> JarClassPathFolders(sourceCode)
    else -> EasyClassPathFolders()
}

class JarClassPathFolders(private val sourceCode: SourceCode) : Folders {
    override fun filesIn(path: String): List<File> {
        return sourceCode.jarFilesAndFoldersPaths()
                .filter { it.matches(Regex("^$path/[^/]+\\.\\w+$")) }
                .map { ClassPathFile(it) }
    }
}

class EasyClassPathFolders : Folders {
    override fun filesIn(path: String) = ClassPathFile(path)
            .lines()
            .map { "$path/$it" }
            .map { ClassPathFile(it) }
}

