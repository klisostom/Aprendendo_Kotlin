
import merge.sort.MergeSort
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MergeSortTest {
    @Test
    fun `Sorting an array with mergesort`() {
        // Arrange (Organizar)
        val tempArray = intArrayOf(12, 3, 7, 9, 14, 6, 11, 2)
        val expectedArray = intArrayOf(2, 3, 6, 7, 9, 11, 12, 14)

        // Act (Agir)
        val lengthArray = (tempArray.size) - 1
        val firstIndex = 0

        val merge = MergeSort(tempArray, firstIndex, lengthArray)
        merge.sort()

        // Assert (Verificar)
        assertArrayEquals(expectedArray, tempArray)
    }
}