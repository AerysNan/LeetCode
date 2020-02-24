/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public int findMinArrowShots(int[][] points) {
    if (points.length == 0)
      return 0;
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        return Integer.compare(i1[0], i2[0]);
      }
    });
    int result = 1, border = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] <= border)
        border = Math.min(border, points[i][1]);
      else {
        result++;
        border = points[i][1];
      }
    }
    return result;
  }
}
// @lc code=end

