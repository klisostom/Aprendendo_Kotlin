package heap.sort

class HeapSort() {

    fun sort(arr: IntArray) {}

    /**
     * Constrói um Max-Heap a partir de um array.
     *
     * @param arr O array que representa o heap. (Equivalente a 'A' no Cormen)
     * @param n O número de elementos no heap. (Equivalente a 'heap-size' sendo definido como 'n')
     *          Assume-se que os elementos estão nos índices 0 até n-1.
     */
    private fun buildMaxHeap(arr: IntArray, n: Int) {
        // Laço convertido da indexação base-1 do Cormen (⌊n/2⌋ downto 1)
        // para indexação base-0 em Kotlin (⌊n/2⌋ - 1 downto 0).
        for (i in (n / 2 - 1) downTo 0) {
            // Chama maxHeapify, passando 'n' como o tamanho do heap,
            // conforme a linha 1 do pseudocódigo do Cormen define heap-size = n.
            maxHeapify(arr, i, n)
        }
    }

    /**
     * Mantém a propriedade do Max-Heap para um nó e seus descendentes.
     *
     * Assume que as árvores binárias com raízes em leftChildIndex(index) e right(index)
     * são max-heaps, mas o elemento em index pode ser menor que seus filhos,
     * violando a propriedade do max-heap.
     *
     * @param arr O array representando o heap.
     * @param index O índice do nó raiz da subárvore que pode violar o max-heap.
     * @param heapSize O tamanho atual do heap dentro do array.
     */
    private fun maxHeapify(arr: IntArray, index: Int, heapSize: Int) {
        val leftChildIndex = left(index) // Assume left(i) = 2 * i + 1
        val rightChildIndex = right(index) // Assume right(i) = 2 * i + 2
        var largest = index // Inicialmente, assumimos que o pai é o maior

        // Verifica se o filho esquerdo existe (dentro do heapSize) e é maior que o pai
        if (leftChildIndex < heapSize && arr[leftChildIndex] > arr[index])  {
            largest = leftChildIndex
        }

        // Verifica se o filho direito existe (dentro do heapSize) e é maior que o maior até agora
        if (rightChildIndex < heapSize && arr[rightChildIndex] > arr[largest]) {
            largest = rightChildIndex
        }

        // Se um dos filhos foi encontrado como maior, precisamos corrigir
        if (largest != index) {
            val temp = arr[index]
            arr[index] = arr[largest]
            arr[largest] = temp

            // Recursivamente corrige o heap afetado
            maxHeapify(arr, largest, heapSize)
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