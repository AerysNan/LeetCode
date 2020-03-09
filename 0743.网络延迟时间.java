/*
 * @lc app=leetcode.cn id=743 lang=java
 *
 * [743] 网络延迟时间
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
  public int networkDelayTime(int[][] times, int N, int K) {
    HashMap<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] edge : times) {
      if (!graph.containsKey(edge[0]))
        graph.put(edge[0], new ArrayList<int[]>());
      graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
    }
    PriorityQueue<int[]> heap = new PriorityQueue<int[]>((info1, info2) -> info1[0] - info2[0]);
    heap.offer(new int[] {0, K});
    HashMap<Integer, Integer> dist = new HashMap<>();

    while (!heap.isEmpty()) {
      int[] info = heap.poll();
      int d = info[0], node = info[1];
      if (dist.containsKey(node))
        continue;
      dist.put(node, d);
      if (graph.containsKey(node))
        for (int[] edge : graph.get(node)) {
          int neighbour = edge[0], d2 = edge[1];
          if (!dist.containsKey(neighbour))
            heap.offer(new int[] {d + d2, neighbour});
        }
    }
    if (dist.size() != N)
      return -1;
    int result = 0;
    for (int cand : dist.values())
      result = Math.max(result, cand);
    return result;
  }
}
// @lc code=end

