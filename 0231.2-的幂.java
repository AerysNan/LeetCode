/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n == 0)
      return false;
    while (n != 1) {
      if ((n & 1) != 0)
        return false;
      n >>= 1;
    }
    return true;
  }
}
// @lc code=end

