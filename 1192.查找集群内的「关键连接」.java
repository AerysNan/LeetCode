/*
 * @lc app=leetcode.cn id=1192 lang=java
 *
 * [1192] 查找集群内的「关键连接」
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
  ArrayList<List<Integer>> result = new ArrayList<>();
  int[] id, low;
  ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
  int count = 0;

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<>());
    for (List<Integer> connection : connections) {
      adj.get(connection.get(0)).add(connection.get(1));
      adj.get(connection.get(1)).add(connection.get(0));
    }
    id = new int[n];
    low = new int[n];
    for (int i = 0; i < n; i++)
      if (id[i] == 0)
        tarjan(i, i);
    return result;
  }

  void tarjan(int u, int parent) {
    id[u] = ++count;
    low[u] = id[u];
    for (int v : adj.get(u)) {
      if (id[v] == 0) {
        tarjan(v, u);
        low[u] = Math.min(low[u], low[v]);
        if (low[v] > id[u]) {
          ArrayList<Integer> list = new ArrayList<>();
          list.add(v);
          list.add(u);
          result.add(list);
        }
      } else if (id[v] < id[u] && v != parent)
        low[u] = Math.min(low[u], id[v]);
    }
  }
}
// @lc code=end

