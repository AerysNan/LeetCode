/*
 * @lc app=leetcode.cn id=834 lang=java
 *
 * [834] 树中距离之和
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
  int[] result, count;
  int n;
  ArrayList<HashSet<Integer>> graph;

  public int[] sumOfDistancesInTree(int N, int[][] edges) {
    n = N;
    result = new int[n];
    count = new int[n];
    graph = new ArrayList<>();
    for (int i = 0; i < n; i++)
      graph.add(new HashSet<>());
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    Arrays.fill(count, 1);
    dfs(0, -1);
    solve(0, -1);
    return result;
  }

  void dfs(int current, int prev) {
    for (int next : graph.get(current)) {
      if (next == prev)
        continue;
      dfs(next, current);
      count[current] += count[next];
      result[current] += result[next] + count[next];
    }
  }

  void solve(int current, int prev) {
    for (int next : graph.get(current)) {
      if (next == prev)
        continue;
      result[next] = result[current] - count[next] * 2 + n;
      solve(next, current);
    }
  }
}
// @lc code=end
