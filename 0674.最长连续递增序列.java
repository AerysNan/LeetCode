/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int result = 0, l = 0;
        for (int r = 0; r < nums.length; ++r) {
            if (r > 0 && nums[r - 1] >= nums[r])
                l = r;
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
// @lc code=end
