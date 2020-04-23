/*
 * @lc app=leetcode.cn id=477 lang=java
 *
 * [477] 汉明距离总和
 */

// @lc code=start
class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += nums[j] & 1;
                nums[j] >>= 1;
            }
            result += count * (n - count);
        }
        return result;
    }
}
// @lc code=end
