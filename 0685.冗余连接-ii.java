/*
 * @lc app=leetcode.cn id=685 lang=java
 *
 * [685] 冗余连接 II
 */

// @lc code=start
class UFS {
  int[] parents;
  int size;

  UFS(int size) {
    parents = new int[size + 1];
    for (int i = 1; i <= size; i++)
      parents[i] = i;
    this.size = size;
  }

  void union(int i, int j) {
    int x = parent(i), y = parent(j);
    if (x != y) {
      parents[x] = y;
      size--;
    }
  }

  boolean connected(int i, int j) {
    return parent(i) == parent(j);
  }

  int parent(int i) {
    if (parents[i] == i)
      return i;
    parents[i] = parent(parents[i]);
    return parents[i];
  }
}


class Solution {
  public int[] findRedundantDirectedConnection(int[][] edges) {
    int[] degree = new int[edges.length + 1];
    for (int[] edge : edges)
      degree[edge[1]]++;
    for (int i = edges.length - 1; i >= 0; i--)
      if (degree[edges[i][1]] == 2)
        if (helper(edges, i))
          return edges[i];
    UFS ufs = new UFS(edges.length);
    for (int[] edge : edges) {
      if (ufs.connected(edge[0], edge[1]))
        return edge;
      ufs.union(edge[0], edge[1]);
    }
    return null;
  }

  public boolean helper(int[][] edges, int i) {
    UFS ufs = new UFS(edges.length);
    for (int j = 0; j < edges.length; j++) {
      if (i == j)
        continue;
      ufs.union(edges[j][0], edges[j][1]);
    }
    return ufs.size == 1;
  }
}
// @lc code=end

