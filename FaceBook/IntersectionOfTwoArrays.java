import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        int reasonableSize = Math.max(nums1.length, nums2.length);

        HashSet<Integer> uniqMembers = new HashSet<>(reasonableSize);
        List<Integer> result = new ArrayList<>(reasonableSize);

        for (int cNum : nums1) {
            uniqMembers.add(cNum);
        }

        for (int cNum : nums2) {
            if (uniqMembers.remove(cNum)) {
                result.add(cNum);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}

/**
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2] i
 * 
 * {1, 2}
 * 
 * [2, ]
 * 
 * 
 * HashSet<Integer> uniqMembers = { } int[] result = [] int index = 0;
 * 
 * for (int i = 0; i < nums1.length; i++) { int cNum = nums1[i]; if
 * (uniqMembers.containsKey(cNum)) { uniqMembers.add(cNum); }
 * 
 * for (int i = 0; i < nums2.length; i++) { int cNum = nums2[i]; if
 * (uniqMembers.containsKey(cNum)) { result[index] = cNum; index++; } }
 * 
 * return result; }
 * 
 * 
 * 
 */