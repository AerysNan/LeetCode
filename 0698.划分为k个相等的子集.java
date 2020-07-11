/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    boolean search(int[] nums, boolean[] used, int k, int target, int current, int start) {
        if (k == 0)
            return true;
        if (current == target)
            return search(nums, used, k - 1, target, 0, 0);
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && current + nums[i] <= target) {
                used[i] = true;
                if (search(nums, used, k, target, current + nums[i], i + 1))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum(), max = Arrays.stream(nums).max().getAsInt();
        if (sum % k != 0 || max > sum / k)
            return false;
        boolean[] used = new boolean[nums.length];
        return search(nums, used, k, sum / k, 0, 0);
    }
}
// @lc code=end
