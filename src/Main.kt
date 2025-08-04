import insertion.sort.InsertionSort

fun sortingWithInsertionSort() {
    val listA = intArrayOf(32, 23, 45, 87, 92, 31, 19)
    val insertionSort = InsertionSort(listA, listA.size.toByte())

    insertionSort.sorting().forEach { i -> print("$i ") }
}

fun main() {
    sortingWithInsertionSort()
}
