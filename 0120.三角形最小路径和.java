/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
import java.util.List;

class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    for (int i = triangle.size() - 2; i >= 0; i--)
      for (int j = 0; j <= i; j++)
        triangle.get(i).set(j, triangle.get(i).get(j)
            + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
    return triangle.get(0).get(0);
  }
}
// @lc code=end

