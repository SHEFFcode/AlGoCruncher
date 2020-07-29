object Solution extends App {
  def matrix(n: Int) = {
    val container = Array.ofDim[Int](n, n)
    var startColumn = 0
    var endColumn = n - 1
    var startRow = 0
    var endRow = n - 1
    var counter = 1
    def recursiveFiller(): Unit = {
      if (startColumn > endColumn || startRow > endRow) return

      // fill out the top row
      (startColumn to endColumn).foreach((i) => {
        container(startRow)(i) = counter
        counter += 1
      })
      startRow += 1 // increment the start row

      (startRow to endRow).foreach((i) => {
        container(i)(endColumn) = counter
        counter += 1
      })
      endColumn -= 1 // decrement column

      (endColumn to startColumn by -1).foreach((i) => {
        container(endRow)(i) = counter
        counter += 1
      })
      endRow -= 1

      (endRow to startRow by -1).foreach(i => {
        container(i)(startColumn) = counter
        counter += 1
      })
      startColumn += 1

      recursiveFiller()
    }

    recursiveFiller()

    runtime.ScalaRunTime.stringOf(container)
  }

  println(matrix(3))
}

/**
  * matrix(3)
  *
  * [
  *  [1, 2, 3],
  *  [8, 9, 4],
  *  [7, 6, 5]
  * ]
  *
  * we will maintain a starting and ending row
  * as well as a starting and ending column
  */
