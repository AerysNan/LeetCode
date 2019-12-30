/*
 * @lc app=leetcode.cn id=390 lang=java
 *
 * [390] 消除游戏
 */

// @lc code=start
class Solution {
  public int lastRemaining(int n) {
    return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
  }
}
// @lc code=end

