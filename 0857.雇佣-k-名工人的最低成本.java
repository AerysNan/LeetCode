/*
 * @lc app=leetcode.cn id=857 lang=java
 *
 * [857] 雇佣 K 名工人的最低成本
 */

// @lc code=start
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collections;

class Solution {
  public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
    int n = quality.length;
    int[][] workers = new int[n][2];
    for (int i = 0; i < n; i++) {
      workers[i][0] = quality[i];
      workers[i][1] = wage[i];
    }
    Arrays.sort(workers, (x, y) -> (Double.compare((double) x[1] / x[0], (double) y[1] / y[0])));
    double result = 1e9;
    int qualitySum = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    for (int[] worker : workers) {
      queue.offer(worker[0]);
      qualitySum += worker[0];
      if (queue.size() > K)
        qualitySum -= queue.poll();
      if (queue.size() == K)
        result = Math.min(result, qualitySum * (double) worker[1] / worker[0]);
    }
    return result;
  }
}
// @lc code=end
