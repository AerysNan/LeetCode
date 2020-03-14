/*
 * @lc app=leetcode.cn id=1368 lang=java
 *
 * [1368] 使网格图至少有一条有效路径的最小代价
 */

// @lc code=start
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
  int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int minCost(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    ArrayList<ArrayList<Pair<Integer, Integer>>> adj = new ArrayList<>();
    for (int i = 0; i < m * n; i++)
      adj.add(new ArrayList<>());
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < 4; k++) {
          int x = i + dirs[k][0], y = j + dirs[k][1];
          if (x < 0 || x >= m || y < 0 || y >= n)
            continue;
          adj.get(i * n + j).add(new Pair<>(x * n + y, grid[i][j] == k + 1 ? 0 : 1));
        }
      }
    }
    int[] distance = new int[m * n];
    for (int i = 1; i < m * n; i++)
      distance[i] = Integer.MAX_VALUE;
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    deque.addFirst(0);
    while (!deque.isEmpty()) {
      int v = deque.pollFirst();
      ArrayList<Pair<Integer, Integer>> neighbours = adj.get(v);
      for (Pair<Integer, Integer> neighbour : neighbours) {
        if (distance[neighbour.getKey()] > distance[v] + neighbour.getValue()) {
          distance[neighbour.getKey()] = distance[v] + neighbour.getValue();
          if (neighbour.getValue() == 0)
            deque.addFirst(neighbour.getKey());
          else
            deque.addLast(neighbour.getKey());
        }
      }
    }
    return distance[m * n - 1];
  }
}
// @lc code=end

