/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于K的子数组
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int product = 1, result = 0, l = 0;
        for (int r = 0; r < nums.length; r++) {
            product *= nums[r];
            while (product >= k)
                product /= nums[l++];
            result += r - l + 1;
        }
        return result;
    }
}
// @lc code=end
