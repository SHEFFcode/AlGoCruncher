object Solution {
  val NEITHER = "Neither"
  def validIPAddress(IP: String): String = {
    if (IP.count(_ == '.') == 3) validateIPv4(IP.split("\\.", -1))
    else if (IP.count(_ == ':') == 7) validateIPv6(IP.split("\\:", -1))
    else NEITHER
  }

  private def validateIPv4(ip: Array[String]): String = {
    for (piece <- ip) {
      // Validate integer in range (0, 255):
      // 1. length of chunk is between 1 and 3
      if (piece.length == 0 || piece.length > 3) return NEITHER
      // 2. no extra leading zeros
      if (piece(0) == '0' && piece.length != 1) return NEITHER
      // 3. only digits are allowed
      for (c <- piece) {
        if (!c.isDigit) return NEITHER
      }
      // 4. less than 255
      if (piece.toInt > 255) return NEITHER
    }

    "IPv4"
  }

  private def validateIPv6(ip: Array[String]): String = {
    val hexdigits = "0123456789abcdefABCDEF"
    for (x <- ip) {
      // Validate hexadecimal in range (0, 2**16):
      // 1. at least one and not more than 4 hexdigits in one chunk
      if (x.length == 0 || x.length > 4) return NEITHER
      // 2. only hexdigits are allowed: 0-9, a-f, A-F
      for (c <- x) {
        if (hexdigits.indexOf(c) == -1) return "Neither";
      }
    }
    "IPv6"
  }
}

/*
G: IP: String
O: ipType: String
T: O(n)
S: O(n)

Notes:
  - "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type
  - A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros
  - A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
    ^ 1 <= xi.length <= 4
    ^ xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
    ^ Leading zeros are allowed in xi.

Ex:

 */
