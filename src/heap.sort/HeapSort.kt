package heap.sort

class HeapSort() {

    fun sort(arr: IntArray) {}

    /**
     * Mantém a propriedade do Max-Heap para um nó e seus descendentes.
     *
     * Assume que as árvores binárias com raízes em left(index) e right(index)
     * são max-heaps, mas o elemento em index pode ser menor que seus filhos,
     * violando a propriedade do max-heap.
     *
     * @param arr O array representando o heap.
     * @param index O índice do nó raiz da subárvore que pode violar o max-heap.
     * @param heapSize O tamanho atual do heap dentro do array.
     */
    private fun maxHeapify(arr: IntArray, index: Int) {
        val left = left(index)
        val right = right(index)
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
    private fun left(parentIndex: Int): Int = 2 * parentIndex + 1

    /**
     * Calcula o índice do filho direito de um nó em um heap.
     *
     * @param parentIndex O índice do nó pai.
     * @return O índice do filho direito.
     */
    private fun right(parentIndex: Int): Int = 2 * parentIndex + 2

    /**
     * Calcula o índice do pai de um nó em um heap.
     *
     * @param childIndex O índice do nó filho.
     * @return O índice do nó pai.
     */
    private fun parent(childIndex: Int): Int = (childIndex - 1) shr 1
}