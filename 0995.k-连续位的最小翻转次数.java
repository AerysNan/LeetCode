/*
 * @lc app=leetcode.cn id=995 lang=java
 *
 * [995] K 连续位的最小翻转次数
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
  public int minKBitFlips(int[] A, int K) {
    LinkedList<Integer> queue = new LinkedList<>();
    int n = A.length, index = 0, result = 0;
    while (true) {
      if (!queue.isEmpty() && queue.peek() + K <= index)
        queue.poll();
      if (index >= n)
        break;
      if (queue.size() % 2 == A[index]) {
        queue.offer(index);
        result++;
      }
      index++;
    }
    return queue.isEmpty() ? result : -1;
  }
}
// @lc code=end
