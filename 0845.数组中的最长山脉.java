/*
 * @lc app=leetcode.cn id=845 lang=java
 *
 * [845] 数组中的最长山脉
 */

// @lc code=start
class Solution {
  public int longestMountain(int[] A) {
    int n = A.length, result = 0;
    if (n == 0)
      return 0;
    int[] up = new int[n], down = new int[n];
    up[0] = 0;
    for (int i = 1; i < n; i++)
      if (A[i] > A[i - 1])
        up[i] = up[i - 1] + 1;
    down[n - 1] = 0;
    for (int i = n - 2; i >= 0; i--)
      if (A[i] > A[i + 1])
        down[i] = down[i + 1] + 1;
    for (int i = 1; i < n - 1; i++) {
      if (up[i] == 0 || down[i] == 0)
        continue;
      result = Math.max(result, up[i] + down[i] + 1);
    }
    return result;
  }
}
// @lc code=end
