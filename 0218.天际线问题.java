/*
 * @lc app=leetcode.cn id=218 lang=java
 *
 * [218] 天际线问题
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public List<List<Integer>> getSkyline(int[][] buildings) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    List<List<Integer>> result = new ArrayList<>();
    queue.add(0);
    int n = buildings.length;
    int[][] points = new int[n * 2][2];
    for (int i = 0; i < n; i++) {
      points[i * 2][0] = buildings[i][0];
      points[i * 2][1] = buildings[i][2];
      points[i * 2 + 1][0] = buildings[i][1];
      points[i * 2 + 1][1] = -buildings[i][2];
    }
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        int v = Integer.compare(i1[0], i2[0]);
        if (v != 0)
          return v;
        return Integer.compare(i2[1], i1[1]);
      }
    });
    for (int[] point : points) {
      if (point[1] > 0) {
        if (queue.peek() < point[1])
          result.add(Arrays.asList(point[0], point[1]));
        queue.add(point[1]);
      } else {
        int h = -point[1];
        queue.remove(h);
        if (queue.peek() < h)
          result.add(Arrays.asList(point[0], queue.peek()));
      }
    }
    return result;
  }
}
// @lc code=end

