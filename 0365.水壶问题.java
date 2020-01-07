/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 */

// @lc code=start
class Solution {
  public boolean canMeasureWater(int x, int y, int z) {
    return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
  }

  int gcd(int x, int y) {
    return y == 0 ? x : gcd(y, x % y);
  }
}
// @lc code=end

