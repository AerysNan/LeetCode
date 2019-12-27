/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 */

// @lc code=start
class Solution {
  public int countDigitOne(int n) {
    int ones = 0;
    for (long m = 1; m <= n; m *= 10)
      ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? 1 : 0) * (n % m + 1);
    return ones;
  }
}
// @lc code=end

