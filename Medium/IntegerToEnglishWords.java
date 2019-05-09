class Solution {
  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }

    int n = num;
    int i = 0;
    StringBuilder words = new StringBuilder();

    String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

    while (n > 0) { // because we are dealing with ints, any number under 1000 will round down to 0
                    // and make this false
      if (n % 1000 != 0) {
        String prepend = helper(n % 1000, LESS_THAN_20, TENS, THOUSANDS) + THOUSANDS[i] + " ";
        words.insert(0, prepend);
      }
      n /= 1000;
      i++;
    }

    return words.toString().trim();
  }

  private String helper(int n, String[] LESS_THAN_20, String[] TENS, String[] THOUSANDS) {
    if (n == 0) {
      return "";
    } else if (n < 20) {
      return LESS_THAN_20[n] + " ";
    } else if (n < 100) {
      return TENS[n / 10] + " " + helper(n % 10, LESS_THAN_20, TENS, THOUSANDS);
    } else {
      return LESS_THAN_20[n / 100] + " Hundred " + helper(n % 100, LESS_THAN_20, TENS, THOUSANDS);
    }
  }
}