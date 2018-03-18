package fr.hadrienmp.random_estimates.lib

interface Folders {
    fun filesIn(path: String): List<File>
}

val classPathFolders = classPathFolders()

fun classPathFolders(resourceFiles: ResourceFiles = ResourceFiles()) = when {
    resourceFiles.areInJar() -> JarClassPathFolders(resourceFiles)
    else -> EasyClassPathFolders()
}

class JarClassPathFolders(private val resourceFiles: ResourceFiles) : Folders {
    override fun filesIn(path: String): List<File> {
        return resourceFiles.jarFilesAndFoldersPaths()
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

