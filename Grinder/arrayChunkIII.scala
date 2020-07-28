object Solution extends App {
  def chunk(arr: Array[Int], chunk: Int) = {
    val totalChunks = math.ceil(arr.size / chunk.toFloat).toInt // we need to be able to round up here
    val result = new Array[Array[Int]](totalChunks)
    (0 until totalChunks).foreach(chunkIndex => {
      val adjustedIndex = chunkIndex * chunk
      val currArr = arr.slice(adjustedIndex, adjustedIndex + chunk)

      result(chunkIndex) = currArr
    })
    result
  }

  println(runtime.ScalaRunTime.stringOf(chunk(Array(1, 2, 3, 4), 10)))
}