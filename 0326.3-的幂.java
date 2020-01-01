/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 */

// @lc code=start
class Solution {
  public boolean isPowerOfThree(int n) {
    if (n == 0)
      return false;
    while (n % 3 == 0)
      n /= 3;
    return n == 1;
  }
}
// @lc code=end

