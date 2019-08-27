/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
  public int uniquePaths(int m, int n) {
    if (m == 1 || n == 1)
      return 1;
    m--;
    n--;
    m += n;
    n = Math.min(n, m - n);
    m -= n;
    long result = 1;
    for (int i = m + 1, j = 1; j <= n; i++, j++) {
      result *= i;
      result /= j;
    }
    return (int) result;
  }
}
// @lc code=end
