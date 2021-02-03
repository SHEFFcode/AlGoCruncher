class Codec {
  val alphabet =
    "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val ALPHABET_LENGTH = alphabet.length
  val map = scala.collection.mutable.HashMap[String, String]()
  val rand = new scala.util.Random()
  var key = nextKey() // precomputed
  val KEY_LENGTH = 6

  // creates a totally random 6 letter hash
  private def nextKey(): String = {
    val sb = new StringBuilder()
    for (i <- 0 until KEY_LENGTH) {
      sb.append(alphabet(rand.nextInt(ALPHABET_LENGTH)))
    }
    sb.toString
  }
  // Encodes a URL to a shortened URL.
  def encode(longURL: String): String = {
    while (map.contains(key)) { // no collision
      key = nextKey() // compute next key
    }
    map(key) = longURL
    s"http://tinyurl.com/$key"
  }

  // Decodes a shortened URL to its original URL.
  def decode(shortURL: String): String = {
    map.getOrElse(shortURL.drop(19), "")
  }
}

/**
  * Your Codec object will be instantiated and called as such:
  * var obj = new Codec()
  * val s = obj.encode(longURL)
  * val ans = obj.decode(s)
  */
