object Solution {
  def findDuplicate(nums: Array[Int]): Int = {

    // will find the value where cycle pointers met,
    // not the actual repeated value (or start of cycle)
    def getValueAtCycle(fpt: Int, spt: Int): Int = {
      if (fpt == spt) spt
      else getValueAtCycle(nums(nums(fpt)), nums(spt))
    }

    // once we know where the pointers met, we can find the
    // start of cycle by moving one step at a time.
    def getValueThatStartedCycle(fpt: Int, spt: Int): Int = {
      if (fpt == spt) spt
      else getValueThatStartedCycle(nums(fpt), nums(spt))
    }
    val initialSeed = nums(0) // any random number can be the seed.
    // fast pointer will call nums 2x, slow pointer will call it 1x
    val valueWhenCycleDetected =
      getValueAtCycle(nums(nums(initialSeed)), nums(initialSeed))

    // if we start at initial seed and cycle value and traverse the array
    // we will end up finding the first instance of duplicate number
    getValueThatStartedCycle(initialSeed, valueWhenCycleDetected)
  }
}
