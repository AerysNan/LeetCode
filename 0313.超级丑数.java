/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
  public int nthSuperUglyNumber(int n, int[] primes) {
    int m = primes.length;
    int[] result = new int[n], indexes = new int[m];
    result[0] = 1;
    for (int i = 1; i < n; i++) {
      int value = Integer.MAX_VALUE;
      for (int j = 0; j < m; j++)
        value = Math.min(value, primes[j] * result[indexes[j]]);
      for (int j = 0; j < m; j++)
        if (value == primes[j] * result[indexes[j]])
          indexes[j]++;
      result[i] = value;
    }
    return result[n - 1];
  }
}
// @lc code=end

