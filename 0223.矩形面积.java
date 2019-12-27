/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 */

// @lc code=start
class Solution {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int overlap = 0;
    int l = Math.max(A, E), r = Math.min(C, G);
    int d = Math.max(B, F), u = Math.min(D, H);
    if (l < r && d < u)
      overlap = (r - l) * (u - d);
    return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
  }
}
// @lc code=end

