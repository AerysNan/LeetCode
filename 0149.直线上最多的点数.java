/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

// @lc code=start
import java.util.HashMap;

class Solution {
  public int maxPoints(int[][] points) {
    if (points == null)
      return 0;
    int n = points.length;
    if (n <= 2)
      return n;
    int result = 0;
    for (int i = 0; i < n - 1; i++) {
      HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
      int overlap = 0, max = 0;
      for (int j = i + 1; j < n; j++) {
        int x = points[i][0] - points[j][0];
        int y = points[i][1] - points[j][1];
        if (x == 0 && y == 0) {
          overlap++;
          continue;
        }
        int gcd = GCD(x, y);
        x /= gcd;
        y /= gcd;
        if (map.containsKey(x))
          map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
        else {
          HashMap<Integer, Integer> kv = new HashMap<>();
          kv.put(y, 1);
          map.put(x, kv);
        }
        max = Math.max(max, map.get(x).get(y));
      }
      result = Math.max(result, max + overlap + 1);
    }
    return result;
  }

  private static int GCD(int a, int b) {
    return b == 0 ? a : GCD(b, a % b);
  }
}
// @lc code=end
