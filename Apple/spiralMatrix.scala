object Solution {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    snail(matrix.toList.map(_.toList))
  }

  private def snail(xs: List[List[Int]]): List[Int] =
    xs match {
      case Nil     => Nil
      case x :: xs => x ++ snail(xs.transpose.reverse)
    }
}

/*
G: matrix: Array[Array[Int]]
O: unwrappedMatrix: List[Int]
T: O(r * c)
S: O(r * c) if the output array is taken into account

Notes:

Ex:

 */
