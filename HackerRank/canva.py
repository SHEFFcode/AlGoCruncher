def maxSubArrayLen(nums, k):
    max_subarray_length, sum = 0, 0               # answer and the accumulative value of nums
    map = {0: -1}                 #key is acc value, and value is the index
    for i in xrange(len(nums)):
        sum += nums[i]
        if sum not in map:
            map[sum] = i
        if sum - k in map:
            max_subarray_length = max(max_subarray_length, i - map[sum-k])
    return max_subarray_length

maxSubArrayLen([3, 5, 4, 3], 7)