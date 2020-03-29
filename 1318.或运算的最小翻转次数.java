/*
 * @lc app=leetcode.cn id=1318 lang=java
 *
 * [1318] 或运算的最小翻转次数
 */

// @lc code=start
class Solution {
  public int minFlips(int a, int b, int c) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      if (a % 2 == 0 && b % 2 == 0 & c % 2 == 1)
        result++;
      else if (c % 2 == 0) {
        if (a % 2 == 1)
          result++;
        if (b % 2 == 1)
          result++;
      }
      a >>= 1;
      b >>= 1;
      c >>= 1;
    }
    return result;
  }
}
// @lc code=end

