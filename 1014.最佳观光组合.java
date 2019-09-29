/*
 * @lc app=leetcode.cn id=1014 lang=java
 *
 * [1014] 最佳观光组合
 */

// @lc code=start
class Solution {
  public int maxScoreSightseeingPair(int[] A) {
    int n = A.length;
    int[] prefixMax = new int[n];
    for (int i = 1; i < n; i++)
      prefixMax[i] = Math.max(prefixMax[i - 1], A[i - 1] + i - 1);
    int result = Integer.MIN_VALUE;
    for (int i = 1; i < n; i++)
      result = Math.max(result, prefixMax[i] + A[i] - i);
    return result;
  }
}
// @lc code=end

