class Solution(object):
    def kEmptySlots(self, flowers, k):
        """
        :type flowers: List[int]
        :type k: int
        :rtype: int
        """
        if len(flowers) < 2:
            return -1
        flower_number_to_day_converter_for_flower = [0 for i in range(0, len(flowers))]
        for i in range(0, len(flowers)):
            # since there is no 0th flower we need to -1 from flower #,
            # and since positions start at 1 we need to add 1 to index to maintain 0 based arrays
            flower_number_to_day_converter_for_flower[flowers[i] - 1] = i + 1
        # set up the bounds such that we have a sliding window
        # such that the distance from first flower to last flower in range is k
        # of course k is not the exact distance, since distance between 3 and 1 is 2, but k value is 1
        # since there is only one flower between 3 and 1, which is 2.
        # so we add one to k to make algebra work property within the bounds of the problem
        k_window_start_flower, k_window_end_flower = 0, k + 1
        lucky_day = -1  # set the result to -1 for the default case we do not find a day that meets conditions
        # the first flower would not have a preceding flower in the k range, and therefore cannot be the flower
        # we want to check for being within the k range and after its neighbors since it will have no neighbor to
        # its left and therefore cannot be a valid answer to this problem
        for current_flower in range(1, len(flower_number_to_day_converter_for_flower)):
            # Check if the current flower's day of blooming is after the day of blooming of both
            # the start and end flowers in the k range.  If so, we have a flower that has not bloomed
            # by the time the two range keepers are blooming, and the problem criteria holds. We remain
            # in the same k window, but increment the number of the current flower we are looking at
            # to check all the flowers in the k range.
            if flower_number_to_day_converter_for_flower[current_flower] \
                    > flower_number_to_day_converter_for_flower[k_window_start_flower]\
                    and flower_number_to_day_converter_for_flower[current_flower] \
                    > flower_number_to_day_converter_for_flower[k_window_end_flower]:
                        continue  # we keep moving along in the k range window till we hit k window end flower
            # we have successfully reached the end of the k-sized window
            if current_flower == k_window_end_flower:
                # if we have not had a lucky day yet, set it to the later of the start flower or end flower
                if lucky_day == -1:
                    lucky_day = max(flower_number_to_day_converter_for_flower[k_window_start_flower]
                                    , flower_number_to_day_converter_for_flower[k_window_end_flower])
                else:  # since we want the first day the conditions are satisfied we keep a running total here with min
                    lucky_day = min(lucky_day, max(flower_number_to_day_converter_for_flower[k_window_start_flower]
                                    , flower_number_to_day_converter_for_flower[k_window_end_flower]))
            # we did not reach the end of the k-sized window, and the current flower has bloomed before either the
            # k window start flower or the k window end flower. We have to move the window.
            # since current flower is the party pooper for a range that includes any previous numbers
            # we move the k-range window to start with that flower so as to exclude the previous flowers
            # for which this flower has ruined the party.
            k_window_start_flower = current_flower
            k_window_end_flower = k_window_start_flower + k + 1
            if k_window_end_flower >= len(flower_number_to_day_converter_for_flower):
                break
        return lucky_day
solution = Solution()

print (solution.kEmptySlots([10,1,6,4,2,8,9,7,5,3], 1))
# [10,1,6,4,2,8,9,7,5,3]
# 1

# [3,9,2,8,1,6,10,5,4,7]
# 1
