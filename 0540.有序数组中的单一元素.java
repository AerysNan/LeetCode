/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    int find(int[] nums, int l, int r) {
        if (l == r)
            return nums[l];
        int m = (l + r) >> 1;
        if (nums[m] > nums[m - 1] && nums[m] < nums[m + 1])
            return nums[m];
        int d = nums[m] == nums[m - 1] ? m - 1 : m;
        return (d - l) % 2 == 0 ? find(nums, d + 2, r) : find(nums, l, d - 1);
    }
}
// @lc code=end
