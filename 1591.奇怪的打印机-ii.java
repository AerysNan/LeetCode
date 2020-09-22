/*
 * @lc app=leetcode.cn id=1591 lang=java
 *
 * [1591] 奇怪的打印机 II
 */

// @lc code=start
class Solution {
  boolean result = true;

  public boolean isPrintable(int[][] targetGrid) {
    HashMap<Integer, Rectangle> map = new HashMap<>();
    int m = targetGrid.length, n = targetGrid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!map.containsKey(targetGrid[i][j]))
          map.put(targetGrid[i][j], new Rectangle(j, j, i, i, targetGrid[i][j]));
        Rectangle r = map.get(targetGrid[i][j]);
        r.d = Math.max(r.d, i);
        r.u = Math.min(r.u, i);
        r.l = Math.min(r.l, j);
        r.r = Math.max(r.r, j);
      }
    }
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    for (int i : map.keySet()) {
      graph.put(i, new ArrayList<>());
      for (int j : map.keySet()) {
        if (i == j)
          continue;
        if (intersect(map.get(i), map.get(j), targetGrid))
          graph.get(i).add(j);
      }
    }
    HashMap<Integer, Integer> state = new HashMap<>();
    for (int key : map.keySet())
      state.put(key, 0);
    for (int key : map.keySet())
      if (!dfs(key, graph, state))
        return false;
    return true;
  }

  boolean dfs(int current, HashMap<Integer, ArrayList<Integer>> graph, HashMap<Integer, Integer> state) {
    for (int next : graph.get(current)) {
      if (state.get(next) == 2)
        continue;
      if (state.get(next) == 1)
        return false;
      state.put(next, 1);
      if (!dfs(next, graph, state))
        return false;
    }
    state.put(current, 2);
    return true;
  }

  boolean intersect(Rectangle r1, Rectangle r2, int[][] grid) {
    for (int i = r1.u; i <= r1.d; i++)
      for (int j = r1.l; j <= r1.r; j++)
        if (grid[i][j] == r2.v)
          return true;
    return false;
  }
}

class Rectangle {
  int v;
  int l, r, u, d;

  public Rectangle(int l, int r, int u, int d, int v) {
    this.l = l;
    this.r = r;
    this.u = u;
    this.d = d;
    this.v = v;
  }
}
// @lc code=end
