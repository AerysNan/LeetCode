/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
  public int hammingDistance(int x, int y) {
    int z = x ^ y, result = 0;
    while (z != 0) {
      result += z % 2;
      z /= 2;
    }
    return result;
  }
}
// @lc code=end

