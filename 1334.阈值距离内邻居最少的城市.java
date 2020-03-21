/*
 * @lc app=leetcode.cn id=1334 lang=java
 *
 * [1334] 阈值距离内邻居最少的城市
 */

// @lc code=start
class Solution {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    int[][] distance = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        distance[i][j] = Integer.MAX_VALUE;
    for (int[] e : edges) {
      distance[e[0]][e[1]] = e[2];
      distance[e[1]][e[0]] = e[2];
    }
    for (int k = 0; k < n; k++)
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          if (i != j && distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE)
            distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
    int result = -1, min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++)
        if (i != j && distance[i][j] <= distanceThreshold)
          count++;
      if (count <= min) {
        min = count;
        result = i;
      }
    }
    return result;
  }
}
// @lc code=end

