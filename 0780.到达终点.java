/*
 * @lc app=leetcode.cn id=780 lang=java
 *
 * [780] 到达终点
 */

// @lc code=start
class Solution {
  public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    while (tx >= sx && ty >= sy) {
      if (tx == sx && ty == sy)
        return true;
      if (tx > ty)
        tx -= Math.max((tx - sx) / ty, 1) * ty;
      else
        ty -= Math.max((ty - sy) / tx, 1) * tx;
    }
    return false;
  }
}
// @lc code=end
