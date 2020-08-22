/*
 * @lc app=leetcode.cn id=786 lang=java
 *
 * [786] 第 K 个最小的素数分数
 */

// @lc code=start
import java.util.PriorityQueue;

class Solution {
  public int[] kthSmallestPrimeFraction(int[] A, int K) {
    PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> A[a[0]] * A[b[1]] - A[a[1]] * A[b[0]]);
    for (int i = 1; i < A.length; i++)
      queue.add(new int[] { 0, i });
    for (int i = 0; i < K - 1; i++) {
      int[] fraction = queue.poll();
      if (fraction[0]++ < fraction[1])
        queue.offer(fraction);
    }
    int[] result = queue.poll();
    return new int[] { A[result[0]], A[result[1]] };
  }
}
// @lc code=end
