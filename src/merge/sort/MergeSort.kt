package merge.sort

class MergeSort(
    private val arrayA: IntArray,
    private val indexP: Int,
    private val indexR: Int
) {
    private fun getR(): Int = this.indexR
    private fun getP(): Int = this.indexP
    private fun getArrayA(): IntArray = this.arrayA

    private fun merge(
        arrayA: IntArray,
        localP: Int,
        localQ: Int,
        localR: Int
    ) {
        val nL = localQ - localP + 1 // length of A[p : q]
        val nR = localR - localQ     // length of A[q + 1 : r]
        val arrayL = IntArray(nL)
        val arrayR = IntArray(nR)

        for (i in 0 until nL) arrayL[i] = arrayA[localP + i]
        for (j in 0 until nR) arrayR[j] = arrayA[localQ + j + 1]

        var indexI = 0
        var indexJ = 0
        var indexK = localP

        while (indexI < nL && indexJ < nR ) {
            if (arrayL[indexI] <= arrayR[indexJ]) {
                arrayA[indexK] = arrayL[indexI]
                indexI += 1
            } else {
                arrayA[indexK] = arrayR[indexJ]
                indexJ += 1
            }

            indexK++
        }

        while (indexI < nL) {
            arrayA[indexK] = arrayL[indexI]
            indexI += 1
            indexK += 1
        }

        while (indexJ < nR) {
            arrayA[indexK] = arrayR[indexJ]
            indexJ += 1
            indexK += 1
        }

    }

    fun sort() {
        if (getP() >= getR()) return                // caso-base: 0 ou 1 elemento
        val indexQ = (getP() + getR()) / 2          // midpoint of A[p : r]
        MergeSort(getArrayA(), getP(), indexQ).sort()      // recursively sort A[p : q]
        MergeSort(getArrayA(), indexQ + 1, getR()).sort()  // recursively sort A[p : q]
        // Merge A[p : q] and A[q + 1 : r] into A[p : r].
        this.merge(getArrayA(), getP(), indexQ, getR())
    }
}
