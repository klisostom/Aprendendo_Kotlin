package heap.sort

class HeapSort() {

    fun sort(arr: IntArray) {}

    private fun maxHeapify(arr: IntArray, index: Int) {
        val left = Left(index)
        val right = Right(index)
        val heapSize = arr.count()
        var largest = if (left < heapSize && arr[left] > arr[index]) left else index

        if (right < heapSize && arr[right] > arr[largest]) largest = right

        if (largest != index) {
            val temp = arr[index]
            arr[index] = arr[largest]
            arr[largest] = temp

            maxHeapify(arr, largest)
        }
    }

    /**
     * Calcula o índice do filho esquerdo de um nó em um heap.
     *
     * @param parentIndex O índice do nó pai.
     * @return O índice do filho esquerdo.
     */
    private fun Left(parentIndex: Int): Int = 2 * parentIndex + 1

    /**
     * Calcula o índice do filho direito de um nó em um heap.
     *
     * @param parentIndex O índice do nó pai.
     * @return O índice do filho direito.
     */
    private fun Right(parentIndex: Int): Int = 2 * parentIndex + 2

    /**
     * Calcula o índice do pai de um nó em um heap.
     *
     * @param childIndex O índice do nó filho.
     * @return O índice do nó pai.
     */
    private fun PARENT(childIndex: Int): Int = (childIndex - 1) shr 1
}