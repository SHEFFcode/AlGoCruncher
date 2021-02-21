import scala.collection.mutable.HashMap
object Solution {
  private type DenseMatrix = HashMap[Int, Array[(Int, Int)]]
  private type SparseMatrix = Array[Array[Int]]
  def multiply(
      A: Array[Array[Int]],
      B: Array[Array[Int]]
  ): Array[Array[Int]] = {
    val aDense = toDenseMatrix(A)
    val bDense = toDenseMatrix(B)

    toSparseMatrix(multiplyDenseMatrices(aDense, bDense), A.size, A.head.size)
  }

  private def toDenseMatrix(sparseMatrix: SparseMatrix): DenseMatrix = {
    val map = HashMap[Int, Array[(Int, Int)]]()
    for (r <- 0 until sparseMatrix.length) {
      for (c <- 0 until sparseMatrix.head.length) {
        if (sparseMatrix(r)(c) != 0) {
          map(r) = map.getOrElse(r, Array()) :+ Tuple2(c, sparseMatrix(r)(c))
        }
      }
    }
    map
  }

  private def toSparseMatrix(
      denseMatrix: DenseMatrix,
      row: Int,
      col: Int
  ): SparseMatrix = {
    val arr = Array.ofDim[Int](row, col)

    for ((row, colValueArray) <- denseMatrix) {
      for ((col, value) <- colValueArray) {
        arr(row)(col) = value
      }
    }

    arr
  }

  private def multiplyDenseMatrices(
      A: DenseMatrix,
      B: DenseMatrix
  ): DenseMatrix = {
    if (B.size < A.size) return multiplyDenseMatrices(B, A)
    val C: DenseMatrix = HashMap()

    for ((row, colValueArr) <- A) {
      for ((col, value) <- colValueArr) {
        if (B.contains(col)) {
          val bRow = col
          B(col).foreach((bRow) => {
            val (bCol, bValue) = bRow
            C(row) = C.getOrElse(row, Array()) :+ Tuple2(col, value * bValue)
          })
        }
      }
    }

    C
  }
}

/*
G: A: Array[Array[Int]], B: Array[Array[Int]]
O: C: Array[Array[Int]]
T: O(nm)
S: O(nm)

Notes:
  - Given two sparse matrices A and B, return the result of AB.
  - You may assume that A's column number is equal to B's row number.

Ex:

 */
