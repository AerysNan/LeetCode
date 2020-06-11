/*
 * @lc app=leetcode.cn id=566 lang=java
 *
 * [566] 重塑矩阵
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] result = new int[r][c];
        int n = r * c, p = nums.length, q = nums[0].length;
        if (p * q != n)
            return nums;
        for (int i = 0; i < n; i++)
            result[i / c][i % c] = nums[i / q][i % q];
        return result;
    }
}
// @lc code=end
