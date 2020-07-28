object Solution extends App {
  def arrayChunk(arr: Array[Int], chunkSize: Int) = {
    var currentArr = new Array[Int](chunkSize)
    var depth = 0

    arr.zipWithIndex.foldLeft(new Array[Array[Int]](arr.size / chunkSize + 1)) {(acc, itemWithIndex) => {
      val item = itemWithIndex._1
      val index = itemWithIndex._2
      val currentChunk = index % chunkSize + 1

      currentArr(currentChunk - 1) = item

      if (currentChunk == chunkSize || index == arr.size - 1) {
        acc(depth) = currentArr
        currentArr = new Array(chunkSize)
        depth += 1
      }

      acc
    }}
  }

  println(runtime.ScalaRunTime.stringOf(arrayChunk(Array(1, 2, 3, 4, 5), 2)))
}

/*
Chunk([1, 2, 3, 4], 2) => [[1,2], [3,4]]
Chunk([1,2,3,4,5], 2) => [[1,2], [3,4], [5]]
Chunk([1,2,3,4,5], 4) => [[1,2,3,4], [5]]
Chunk([1,2,3,4,5], 10) => [[1,2,3,4,5]]
*/