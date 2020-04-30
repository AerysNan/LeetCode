/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, current = 0;
        for (int num : nums) {
            if (num == 0) {
                result = Math.max(result, current);
                current = 0;
            } else
                current++;
        }
        return Math.max(result, current);
    }
}
// @lc code=end
