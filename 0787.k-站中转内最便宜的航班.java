/*
 * @lc app=leetcode.cn id=787 lang=java
 *
 * [787] K 站中转内最便宜的航班
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<>());
    for (int[] flight : flights)
      adj.get(flight[0]).add(new int[] { flight[1], flight[2] });
    HashMap<Integer, Integer> best = new HashMap<>();
    PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
    queue.offer(new int[] { 0, 0, src });
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int cost = current[0], hop = current[1], node = current[2];
      if (hop > K + 1 || cost > best.getOrDefault((hop << 7) + node, Integer.MAX_VALUE))
        continue;
      if (node == dst)
        return cost;
      for (int[] next : adj.get(node)) {
        int newcost = cost + next[1];
        if (newcost < best.getOrDefault(((hop + 1) << 7) + next[0], Integer.MAX_VALUE)) {
          queue.offer(new int[] { newcost, hop + 1, next[0] });
          best.put(((hop + 1) << 7) + next[0], newcost);
        }
      }
    }
    return -1;
  }
}
// @lc code=end
