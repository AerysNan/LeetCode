/*
 * @lc app=leetcode.cn id=850 lang=java
 *
 * [850] 矩形面积 II
 */

// @lc code=start
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
  public int rectangleArea(int[][] rectangles) {
    int OPEN = 0, CLOSE = 1;
    int[][] events = new int[rectangles.length * 2][4];
    for (int i = 0; i < rectangles.length; i++) {
      events[i * 2] = new int[] { rectangles[i][1], OPEN, rectangles[i][0], rectangles[i][2] };
      events[i * 2 + 1] = new int[] { rectangles[i][3], CLOSE, rectangles[i][0], rectangles[i][2] };
    }
    Arrays.sort(events, (a, b) -> a[0] - b[0]);
    ArrayList<int[]> active = new ArrayList<>();
    int currentY = events[0][0];
    long result = 0;
    for (int[] event : events) {
      int y = event[0], action = event[1], x1 = event[2], x2 = event[3], current = -1;
      long query = 0;
      for (int[] xs : active) {
        current = Math.max(current, xs[0]);
        query += Math.max(xs[1] - current, 0);
        current = Math.max(current, xs[1]);
      }
      result += query * (y - currentY);
      if (action == OPEN) {
        active.add(new int[] { x1, x2 });
        Collections.sort(active, (a, b) -> a[0] - b[0]);
      } else {
        for (int i = 0; i < active.size(); i++)
          if (active.get(i)[0] == x1 && active.get(i)[1] == x2) {
            active.remove(i);
            break;
          }
      }
      currentY = y;
    }
    result %= 1000000007;
    return (int) result;
  }
}
// @lc code=end
