/*
 * @lc app=leetcode.cn id=862 lang=java
 *
 * [862] 和至少为 K 的最短子数组
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
  public int shortestSubarray(int[] A, int K) {
    int n = A.length, result = Integer.MAX_VALUE;
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++)
      sum[i + 1] = sum[i] + A[i];
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 0; i < sum.length; i++) {
      while (!queue.isEmpty() && sum[i] <= sum[queue.getLast()])
        queue.removeLast();
      while (!queue.isEmpty() && sum[i] >= sum[queue.getFirst()] + K)
        result = Math.min(result, i - queue.removeFirst());
      queue.addLast(i);
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
// @lc code=end
