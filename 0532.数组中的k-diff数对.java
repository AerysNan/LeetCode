/*
 * @lc app=leetcode.cn id=532 lang=java
 *
 * [532] 数组中的K-diff数对
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;
        Arrays.sort(nums);
        int result = 0, prev = Integer.MAX_VALUE, n = nums.length;
        int l = 0, r = 1;
        while (r < n) {
            if (nums[r] - nums[l] > k || prev == nums[l]) {
                l++;
                if (l == r)
                    r++;
            } else {
                if (nums[r] - nums[l] == k) {
                    prev = nums[l++];
                    result++;
                }
                r++;
            }
        }
        return result;
    }
}
// @lc code=end
