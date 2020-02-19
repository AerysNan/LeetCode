/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 */

// @lc code=start
import java.util.HashMap;

class Solution {
  public int numberOfBoomerangs(int[][] points) {
    int count = 0;
    for (int i = 0; i < points.length; i++) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int j = 0; j < points.length; j++) {
        if (i == j)
          continue;
        int distance = (points[j][0] - points[i][0]) * (points[j][0] - points[i][0])
            + (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]);
        int size = map.getOrDefault(distance, 0);
        count += size * 2;
        map.put(distance, size + 1);
      }
    }
    return count;
  }
}
// @lc code=end

