/*
 * @lc app=leetcode.cn id=684 lang=java
 *
 * [684] 冗余连接
 */

// @lc code=start
class UFS {
  int[] parents;

  UFS(int size) {
    parents = new int[size];
    for (int i = 0; i < size; i++)
      parents[i] = i;
  }

  void union(int i, int j) {
    parents[parent(i)] = parent(j);
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
  public int[] findRedundantConnection(int[][] edges) {
    UFS ufs = new UFS(1001);
    for (int[] edge : edges) {
      if (ufs.connected(edge[0], edge[1]))
        return edge;
      ufs.union(edge[0], edge[1]);
    }
    return null;
  }
}
// @lc code=end

