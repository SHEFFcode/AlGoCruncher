object Solution extends App {
  def arrayChunk(arr: Array[Int], chunkSize: Int) = {
    arr.grouped(chunkSize).toArray
  }

  println(runtime.ScalaRunTime.stringOf(arrayChunk(Array(1, 2, 3, 4), 2)))
}

/*
Chunk([1, 2, 3, 4], 2) => [[1,2], [3,4]]
Chunk([1,2,3,4,5], 2) => [[1,2], [3,4], [5]]
Chunk([1,2,3,4,5], 4) => [[1,2,3,4], [5]]
Chunk([1,2,3,4,5], 10) => [[1,2,3,4,5]]
*/