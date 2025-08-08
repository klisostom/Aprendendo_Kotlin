
import merge.sort.MergeSort
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MergeSortTest {
    @Test
    fun `Sorting an array with mergesort`() {
        // Arrange (Organizar)
        val tempArray = intArrayOf(2, 4, 6, 7, 1, 2, 3, 5)
        val expectedArray = intArrayOf(1, 2, 2, 3, 4, 5, 6, 7)

        // Act (Agir)
        val lengthArray = (tempArray.size) - 1
        val firstIndex = 0

        val merge = MergeSort(tempArray, firstIndex, lengthArray)
        merge.sort()

        tempArray.forEach { i -> print("$i ") }

        // Assert (Verificar)
        assertArrayEquals(expectedArray, tempArray)
    }
}