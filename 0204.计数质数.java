/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
  public int countPrimes(int n) {
    boolean[] notprime = new boolean[n];
    int result = 0;
    for (int i = 2; i < n; i++) {
      if (notprime[i])
        continue;
      result++;
      for (int j = 2; j * i < n; j++)
        notprime[i * j] = true;
    }
    return result;
  }
}
// @lc code=end

