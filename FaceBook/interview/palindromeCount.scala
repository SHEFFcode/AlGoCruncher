object Solution {
  def countSubstrings(s: String): Int = {
    (0 until s.length).foldLeft(0) {
      case (sum, i) => {
        sum += (
          countPalsAroundCenter(s, i, i) + // odd length pals
            countPalsAroundCenter(s, i, i + 1) // even length pals
        )
      }
    }
  }

  private def countPalsAroundCenter(s: String, l: Int, h: Int): Int = {
    var (lo, hi, ans) = (l, h, 0)

    while (lo > -1 && hi < s.length()) {
      if (s(lo) != s(hi)) return ans
      else {
        lo -= 1
        hi += 1
        ans += 1
      }
    }
    ans
  }
}
