/*
 * @lc app=leetcode.cn id=747 lang=java
 *
 * [747] 至少是其他数字两倍的最大数
 */

// @lc code=start
class Solution {
    public int dominantIndex(int[] nums) {
        int first = -1, second = -1, result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
                result = i;
            } else
                second = Math.max(second, nums[i]);
        }
        return first >= second * 2 ? result : -1;
    }
}
// @lc code=end
