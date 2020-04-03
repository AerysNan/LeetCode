/*
 * @lc app=leetcode.cn id=1175 lang=java
 *
 * [1175] 质数排列
 */

// @lc code=start
class Solution {
  public int numPrimeArrangements(int n) {
    int count = 0;
    boolean[] filter = new boolean[n + 1];
    for (int i = 2; i <= n; i++) {
      if (filter[i])
        continue;
      count++;
      for (int j = i * 2; j <= n; j += i)
        filter[j] = true;
    }
    long result = 1, mod = (long) 1e9 + 7;
    for (int i = 2; i <= count; i++)
      result = result * i % mod;
    for (int i = 2; i <= n - count; i++)
      result = result * i % mod;
    return (int) result;
  }
}
// @lc code=end

