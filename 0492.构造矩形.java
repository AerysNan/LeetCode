/*
 * @lc app=leetcode.cn id=492 lang=java
 *
 * [492] 构造矩形
 */

// @lc code=start
class Solution {
  public int[] constructRectangle(int area) {
    int result = (int) Math.sqrt(area);
    while (true) {
      if (area % result == 0)
        return new int[] {area / result, result};
      result--;
    }
  }
}
// @lc code=end

