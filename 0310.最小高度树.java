/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    if (n == 1)
      return Arrays.asList(n - 1);
    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<>());
    for (int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++)
      if (adj.get(i).size() == 1)
        queue.add(i);

    while (n > 2) {
      int size = queue.size();
      n -= size;
      for (int i = 0; i < size; i++) {
        int u = queue.poll();
        for (int v : adj.get(u)) {
          adj.get(v).remove(Integer.valueOf(u));
          if (adj.get(v).size() == 1)
            queue.add(v);
        }
      }
    }
    ArrayList<Integer> result = new ArrayList<>();
    while (!queue.isEmpty())
      result.add(queue.poll());
    return result;
  }
}
// @lc code=end

