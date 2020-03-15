/*
 * @lc app=leetcode.cn id=1353 lang=java
 *
 * [1353] 最多可以参加的会议数目
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public int maxEvents(int[][] events) {
    PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        return Integer.compare(i1[1], i2[1]);
      }
    });
    Arrays.sort(events, new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        return Integer.compare(i1[0], i2[0]);
      }
    });
    int index = 0, result = 0;
    for (int i = 1; i <= (int) 1e5 && (index < events.length || !queue.isEmpty()); i++) {
      while (index < events.length && events[index][0] == i)
        queue.add(events[index++]);
      while (!queue.isEmpty() && queue.peek()[1] < i)
        queue.poll();
      if (!queue.isEmpty()) {
        result++;
        queue.poll();
      }
    }
    return result;
  }
}
// @lc code=end

