/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 */

// @lc code=start
class Solution {
  public boolean isPowerOfFour(int num) {
    if (num == 0)
      return false;
    while (num > 4) {
      if ((num & 3) != 0)
        return false;
      num >>= 2;
    }
    return num == 4 || num == 1;
  }
}
// @lc code=end

