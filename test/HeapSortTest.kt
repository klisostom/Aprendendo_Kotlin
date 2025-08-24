import heap.sort.HeapSort
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HeapSortTest {
    @Test fun `Sorting a array with HeapSort`() {
        // Arrange
        val tempArray = intArrayOf(27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0)
        val expectedArray = intArrayOf(0, 1, 3, 4, 5, 7, 8, 9, 10, 12, 13, 16, 17, 27)

        // Act
        val heapSort = HeapSort()
        heapSort.sort(tempArray)

        // Assert
        assertEquals(tempArray.size, expectedArray.size)
        assertArrayEquals(expectedArray, tempArray)
    }
}