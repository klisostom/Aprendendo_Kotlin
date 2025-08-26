import heap.sort.HeapSort
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

class HeapSortTest {
    @Test fun `Sorting a array with HeapSort`() {
        // Arrange
        val tempArray = intArrayOf(27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0)
        val expectedArray = intArrayOf(0, 1, 3, 4, 5, 7, 8, 9, 10, 12, 13, 16, 17, 27)

        val tempArrayTwo = intArrayOf(5, 13, 2, 25, 7, 17, 20, 8, 4)
        val expectedArrayTwo = intArrayOf(2, 4, 5, 7, 8, 13, 17, 20, 25)

        // Act
        val heapSort = HeapSort()
        heapSort.sort(tempArray, tempArray.size)
        heapSort.sort(tempArrayTwo, tempArrayTwo.size)

        // Assert
        assertEquals(tempArray.size, expectedArray.size)
        assertArrayEquals(expectedArray, tempArray)

        assertEquals(tempArrayTwo.size, expectedArrayTwo.size)
        assertArrayEquals(expectedArrayTwo, tempArrayTwo)
    }

    @Test
    fun `test already sorted array`() {
        // Arrange
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val expected = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val n = arr.size

        // Act
        val heapSort = HeapSort()
        heapSort.sort(arr, n)

        // Assert
        assertArrayEquals(expected, arr)
    }

    @Test
    fun `test reverse sorted array`() {
        // Arrange
        val arr = intArrayOf(20, 18, 15, 12, 10, 8, 5, 3, 1)
        val expected = intArrayOf(1, 3, 5, 8, 10, 12, 15, 18, 20)
        val n = arr.size

        // Act
        val heapSort = HeapSort()
        heapSort.sort(arr, n)

        // Assert
        assertArrayEquals(expected, arr)
    }

    @Test
    fun `test array with duplicates`() {
        // Arrange
        val arr = intArrayOf(5, 2, 8, 2, 9, 1, 5, 5, 3)
        val expected = intArrayOf(1, 2, 2, 3, 5, 5, 5, 8, 9)
        val n = arr.size

        // Act
        val heapSort = HeapSort()
        heapSort.sort(arr, n)

        // Assert
        assertArrayEquals(expected, arr)
    }

    @Test
    fun `test single element array`() {
        // Arrange
        val arr = intArrayOf(42)
        val expected = intArrayOf(42)
        val n = arr.size

        // Act
        val heapSort = HeapSort()
        heapSort.sort(arr, n)

        // Assert
        assertArrayEquals(expected, arr)
    }

    @Test
    fun `test empty array`() {
        // Arrange
        val arr = intArrayOf()
        val n = arr.size

        // Act
        val heapSort = HeapSort()
        heapSort.sort(arr, n)

        // Assert
        assertArrayEquals(intArrayOf(), arr)
    }

    @Test
    fun `test large random array`() {
        // Arrange
        val size = 1000
        val maxValue = 10000
        val arr = IntArray(size) { Random.nextInt(0, maxValue) }
        val n = arr.size

        // Act
        // Faz uma cópia para comparar com o resultado esperado do sort do Kotlin
        val expectedArr = arr.copyOf()
        expectedArr.sort() // Ordena a cópia usando o sort padrão do Kotlin

        // Act
        val heapSort = HeapSort()
        heapSort.sort(arr, n)

        // Assert
        assertArrayEquals(expectedArr, arr, "Sorted array should match Kotlin's built-in sort")
    }
}