/**
 * @param {number[]} nums
 */
var Solution = function(nums) {
  this.originalState = nums.slice();
  this.currentState = nums;
};

/**
* Resets the array to its original configuration and return it.
* @return {number[]}
*/
Solution.prototype.reset = function() {
  this.currentState = this.originalState.slice();
  return this.currentState;
};

/**
* Returns a random shuffling of the array.
* @return {number[]}
*/
Solution.prototype.shuffle = function() {
  
  
  for (let i = 0; i < this.currentState.length; i++) {
      let firstIndex = i;
      let secondIndex = Math.floor(Math.random() * (this.currentState.length));
      [this.currentState[firstIndex], this.currentState[secondIndex]] = [this.currentState[secondIndex], this.currentState[firstIndex]];
  };
  
  return this.currentState;
};

/** 
* Your Solution object will be instantiated and called as such:
* var obj = Object.create(Solution).createNew(nums)
* var param_1 = obj.reset()
* var param_2 = obj.shuffle()
*/
var obj = new Solution([[[1,2,3]],[],[],[]])
var param_1 = obj.reset()
var param_2 = obj.shuffle()
