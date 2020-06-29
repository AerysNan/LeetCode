/*
 * @lc app=leetcode.cn id=665 lang=java
 *
 * [665] 非递减数列
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        boolean changed = false;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] <= nums[i + 1])
                continue;
            if (changed)
                return false;
            changed = true;
            if (i > 0 && nums[i - 1] > nums[i + 1])
                nums[i + 1] = nums[i];
        }
        return true;
    }
}
// @lc code=end
