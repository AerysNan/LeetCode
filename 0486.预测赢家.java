/*
 * @lc app=leetcode.cn id=486 lang=java
 *
 * [486] 预测赢家
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        return canWin(nums, 0, n - 1, new Integer[n][n]) >= 0;
    }

    int canWin(int[] nums, int l, int r, Integer[][] dp) {
        if (dp[l][r] != null)
            return dp[l][r];
        if (l == r)
            return nums[l];
        int takeL = nums[l] - canWin(nums, l + 1, r, dp);
        int takeR = nums[r] - canWin(nums, l, r - 1, dp);
        int result = Math.max(takeL, takeR);
        dp[l][r] = result;
        return result;
    }
}
// @lc code=end
