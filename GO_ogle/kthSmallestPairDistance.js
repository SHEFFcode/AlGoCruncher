class KSmallestPair {
  // Function to find k pairs with least sum such
  // that one elemennt of a pair is from arr1[] and
  // other element is from arr2[]
  kSmallestPair(nums1, nums2, k) {
    let n1 = nums1.length;
    let n2 = nums2.length;
    if (k > n1 * n2) {
      console.log("k pairs don't exist");
      return;
    }

    // Stores current index in arr2[] for
    // every element of arr1[]. Initially
    // all values are considered 0.
    // Here current index is the index before
    // which all elements are considered as
    // part of output.
    let index2 = [];
    for (let i = 0; i < k; i++) {
      index2[i] = 0;
    }

    while (k > 0) {
      // Initialize current pair sum as infinite
      let min_sum = Number.MAX_SAFE_INTEGER;
      let min_index = 0;

      // To pick next pair, traverse for all 
      // elements of arr1[], for every element, find 
      // corresponding current element in arr2[] and
      // pick minimum of all formed pairs.
      for (let i1 = 0; i1 < n1; i1++)
      {
        // Check if current element of arr1[] plus
        // element of array2 to be used gives 
        // minimum sum
        if (index2[i1] < n2 &&
          nums1[i1] + nums2[index2[i1]] < min_sum) {
          // Update index that gives minimum
          min_index = i1;

          // update minimum sum
          min_sum = nums1[i1] + nums2[index2[i1]];
        }
      }

      console.log("(" + nums1[min_index] + ", " + nums2[index2[min_index]] + ") ");

      index2[min_index]++;
      k--;
    }
  }
}

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number} k
 * @return {number[][]}
 */
var kSmallestPairs = function(nums1, nums2, k) {
    let kSmallestPair = new KSmallestPair();
    kSmallestPair.kSmallestPair(nums1, nums2, k)
};

kSmallestPairs([1,7,11], [2,4,6], 3);