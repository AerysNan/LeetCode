/*
 * @lc app=leetcode.cn id=1377 lang=java
 *
 * [1377] T 秒后青蛙的位置
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
  boolean[] visited;
  double[] prob;

  public double frogPosition(int n, int[][] edges, int t, int target) {
    visited = new boolean[n + 1];
    prob = new double[n + 1];
    visited[1] = true;
    prob[1] = 1;
    for (int i = 0; i <= n; i++)
      adj.add(new ArrayList<>());
    for (int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }
    dfs(t, 1);
    return prob[target];
  }

  void dfs(int t, int current) {
    if (t <= 0)
      return;
    int neighbour = 0;
    for (int n : adj.get(current))
      if (!visited[n])
        neighbour++;
    if (neighbour == 0)
      return;
    double p = prob[current] / neighbour;
    for (int n : adj.get(current)) {
      if (visited[n])
        continue;
      visited[n] = true;
      prob[n] += p;
      prob[current] -= p;
      dfs(t - 1, n);
    }
  }
}
// @lc code=end

