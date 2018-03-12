package fr.hadrienmp.random_estimates.lib

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito

@RunWith(JUnitParamsRunner::class)
class ClassPathFoldersSpec {

    @Test
    fun `should return the files contained in the folder`() {
        val folder = classPathFolders()

        val files = folder.filesIn("data")

        assertThat(files).containsOnly(
                ClassPathFile("data/fr.json"),
                ClassPathFile("data/en.json"))
    }

    @Test
    @Parameters(method = "filesInFolders")
    fun `should return the file contained in the folder in a jar context`(folderName: String, expectedFiles: List<String>) {
        val sourceCode = givenCodeIsInJarWith(listOf("data", "data/fr.json", "data/en.json", "webapp", "webapp/css", "webapp/css/main.css"))
        val folder = classPathFolders(sourceCode = sourceCode)

        val files = folder.filesIn(folderName)

        assertThat(files).isEqualTo(expectedFiles.map { ClassPathFile(it) })
    }

    fun filesInFolders() = listOf(
            listOf("data", listOf("data/fr.json", "data/en.json")),
            listOf("webapp/css", listOf("webapp/css/main.css")))

    @Test
    fun `should not search recursively in a jar context`() {
        val sourceCode = givenCodeIsInJarWith(listOf("data", "data/fr.json", "data/en.json", "data/folder", "data/folder/toto.txt"))
        val folder = classPathFolders(sourceCode = sourceCode)

        val files = folder.filesIn("data")

        assertThat(files).containsOnly(ClassPathFile("data/fr.json"), ClassPathFile("data/en.json"))
    }

    private fun givenCodeIsInJarWith(folders: List<String>): SourceCode {
        val sourceCode = Mockito.mock(SourceCode::class.java)
        given(sourceCode.isInJar()).willReturn(true)
        given(sourceCode.jarFilesAndFoldersPaths()).willReturn(folders)
        return sourceCode
    }
}