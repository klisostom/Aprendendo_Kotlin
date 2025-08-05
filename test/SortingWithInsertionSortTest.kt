import insertion.sort.InsertionSort
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SortingWithInsertionSortTest {
    @Test
    fun sortingWithInsertionSort() {
        // Arrange (Organizar)
        val tempArray = intArrayOf(31, 41, 59, 26, 41, 58)
        val expectedArray = intArrayOf(26, 31, 41, 41, 58, 59)

        // Act (Agir)
        val insertionSort = InsertionSort(tempArray, (tempArray.size).toByte())
        val actualArray = insertionSort.sorting()

        // Assert (Verificar)
        assertArrayEquals(expectedArray, actualArray)
    }

}