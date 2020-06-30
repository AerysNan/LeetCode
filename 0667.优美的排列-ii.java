/*
 * @lc app=leetcode.cn id=667 lang=java
 *
 * [667] 优美的排列 II
 */

// @lc code=start
class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int m = n - k - 1;
        for (int i = 0; i < m; i++)
            result[i] = i + 1;
        for (int i = 0, l = n - k, r = n; i < k + 1; i++)
            result[i + m] = i % 2 == 0 ? l++ : r--;
        return result;
    }
}
// @lc code=end
