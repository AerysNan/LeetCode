/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] buffer = new int[n];
        System.arraycopy(nums, 0, buffer, 0, n);
        Arrays.sort(nums);
        int l = 0, r = n - 1;
        while (l < n && nums[l] == buffer[l])
            l++;
        while (r >= 0 && nums[r] == buffer[r])
            r--;
        return Math.max(0, r - l + 1);
    }
}
// @lc code=end
