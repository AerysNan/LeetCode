import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=5359 lang=java
 *
 * [5359] 最大的团队表现值
 */

// @lc code=start
class Solution {
  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    int[][] workers = new int[n][2];
    for (int i = 0; i < n; i++) {
      workers[i][0] = speed[i];
      workers[i][1] = efficiency[i];
    }
    Arrays.sort(workers, new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        return Integer.compare(i2[1], i1[1]);
      }
    });
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    long sum = 0, result = 0;
    for (int i = 0; i < n; i++) {
      sum += workers[i][0];
      queue.add(workers[i][0]);
      if (queue.size() > k)
        sum -= queue.poll();
      result = Math.max(result, sum * workers[i][1]);
    }
    return (int) (result % (long) (1e9 + 7));
  }
}
// @lc code=end

