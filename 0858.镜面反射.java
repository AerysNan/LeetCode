/*
 * @lc app=leetcode.cn id=858 lang=java
 *
 * [858] 镜面反射
 */

// @lc code=start
class Solution {
  public int mirrorReflection(int p, int q) {
    int g = gcd(p, q);
    int x = p / g, y = q / g;
    return x % 2 == 1 ? (y % 2 == 1 ? 1 : 0) : 2;
  }

  public int gcd(int a, int b) {
    if (a == 0)
      return b;
    return gcd(b % a, a);
  }
}
// @lc code=end
