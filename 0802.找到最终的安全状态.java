/*
 * @lc app=leetcode.cn id=802 lang=java
 *
 * [802] 找到最终的安全状态
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class Solution {
  public List<Integer> eventualSafeNodes(int[][] graph) {
    int n = graph.length;
    ArrayList<ArrayList<Integer>> rgraph = new ArrayList<>();
    for (int i = 0; i < n; i++)
      rgraph.add(new ArrayList<>());
    for (int i = 0; i < n; i++)
      for (int adj : graph[i])
        rgraph.get(adj).add(i);
    int[] degree = Arrays.stream(graph).mapToInt(x -> x.length).toArray();
    ArrayList<Integer> result = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < n; i++)
      if (degree[i] == 0)
        s.push(i);
    while (!s.isEmpty()) {
      int node = s.pop();
      result.add(node);
      for (int next : rgraph.get(node))
        if (--degree[next] == 0)
          s.push(next);
    }
    result.sort(Comparator.naturalOrder());
    return result;
  }
}
// @lc code=end
