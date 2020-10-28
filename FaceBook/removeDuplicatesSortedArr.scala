object Solution {
  def removeDuplicates(nums: Array[Int]): Int = {
    var ndi = if (nums.length > 0) 1 else 0 // non duplicate index

    // we have to be very careful not to go out of bound here, so since
    // we will access nums(i + 1) here
    for (i <- 0 until nums.length - 1) {
      println(s"I am going into index $i")
      if (nums(i) != nums(i + 1)) {
        // we will set the non similar num at the ndi position
        nums(ndi) = nums(i + 1)
        ndi += 1 // we will increment ndi, since sacala does not have a ++ operator
      }
    }

    ndi
  }
}
