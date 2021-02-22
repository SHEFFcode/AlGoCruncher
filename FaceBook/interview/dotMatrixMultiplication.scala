import scala.collection.mutable.HashMap
object Solution {
  private type DenseMatrix = HashMap[(Int, Int), Int]
  private type SparseMatrix = Array[Array[Int]]
  def multiply(
      A: Array[Array[Int]],
      B: Array[Array[Int]]
  ): Array[Array[Int]] = {
    multiplyDenseMatrices(A, B)
  }

  private def toDenseMatrix(sparseMatrix: SparseMatrix): DenseMatrix = {
    val map = HashMap[(Int, Int), Int]()

    for (r <- 0 until sparseMatrix.length) {
      for (c <- 0 until sparseMatrix.head.length) {
        if (sparseMatrix(r)(c) != 0) {
          map((r, c)) = sparseMatrix(r)(c)
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

    for (((row, col), value) <- denseMatrix) {
      arr(row)(col) = value
    }

    arr
  }

  private def multiplyDenseMatrices(
      aSparse: SparseMatrix,
      bSparse: SparseMatrix
  ): SparseMatrix = {
    val aDense = toDenseMatrix(aSparse)
    val bDense = toDenseMatrix(bSparse)
    val cDense: DenseMatrix = HashMap()

    for (((aRow, aCol), aVal) <- aDense) {
      for (bCol <- 0 until bSparse.head.size) {
        val bRow = aCol // for lookup
        if (bDense.contains(bRow, bCol)) {
          val bVal = bDense(bRow, bCol)
          cDense((aRow, bCol)) =
            cDense.getOrElse((aRow, bCol), 0) + (aVal * bVal)
        }
      }
    }

    toSparseMatrix(cDense, aSparse.size, bSparse.head.size)
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
