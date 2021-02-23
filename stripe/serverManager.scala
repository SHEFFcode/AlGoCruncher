import scala.collection.mutable.HashMap

object ServerManager extends App {
  private val keyContainer = HashMap[String, Int]()
  private val MAX_SERVER_COUNT = 3
  private val MIN_SERVER_COUNT = 1

  def allocateKey(key: String): String = {
    val keyCount = keyContainer.getOrElse(key, 0)
    if (keyCount == MAX_SERVER_COUNT) "-1"
    else {
      keyContainer(key) = keyCount + 1
      s"${keyContainer(key)}"
    }
  }

  def deAllocateKey(key: String): String = {
    if (keyContainer.contains(key) && keyContainer(key) > MIN_SERVER_COUNT) {
      keyContainer(key) -= 1
      s"${keyContainer(key)}"
    } else "-1"
  }

  println(allocateKey("apiBox"))
  println(allocateKey("apiBox"))
  println(allocateKey("apiBox"))
  println(allocateKey("apiBox"))
  println(deAllocateKey("apiBox"))
  println(allocateKey("siteBox"))
  println(allocateKey("siteBox"))
  println(deAllocateKey("siteBox"))
  println(deAllocateKey("siteBox"))
}
