object Solution extends App {
  def change(amount: Int, coins: Array[Int]): Int = {
    // this will create an array of size amount + 1, where first element at position 0 is 1
    val sum = 1 +: Array.fill(amount)(0)

    coins.foreach(coin => {
      // if coin is bigger then amount, this will not run
      // if coin is smaller then or equal to amount, it will run
      // starting at the coin, taking into account the count
      // of ways to get to i - coin index and adding it
      // to how many times we can get to i index
      (coin to amount).foreach(i => sum(i) += sum(i - coin))
      // this will then update the field at that index to be the number of ways at that index + number of ways we can get an amount smaller by this coin
    })
    sum.last
  }
}

/*
G: amount: Int, coins: Array[Int]
O: numberOfCombinations: Int
T: O(N)
S: O(n)

Notes:
  - You may assume that you have infinite number of each kind of coin.
  - Write a function to compute the number of combinations that make up that amount.

Ex:

 */
