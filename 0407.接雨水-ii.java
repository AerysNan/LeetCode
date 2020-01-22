/*
 * @lc app=leetcode.cn id=407 lang=java
 *
 * [407] 接雨水 II
 */

// @lc code=start
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public int trapRainWater(int[][] heightMap) {
    if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
      return 0;
    int m = heightMap.length, n = heightMap[0].length;
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer v1, Integer v2) {
        return Integer.compare(heightMap[v1 / n][v1 % n], heightMap[v2 / n][v2 % n]);
      }
    });
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      queue.add(i * n);
      visited[i][0] = true;
      queue.add(i * n + n - 1);
      visited[i][n - 1] = true;
    }
    for (int i = 1; i < n - 1; i++) {
      queue.add(i);
      visited[0][i] = true;
      queue.add((m - 1) * n + i);
      visited[m - 1][i] = true;
    }
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int result = 0, max = Integer.MIN_VALUE;
    while (!queue.isEmpty()) {
      int value = queue.poll(), x = value / n, y = value % n;
      max = Math.max(max, heightMap[x][y]);
      for (int[] dir : dirs) {
        int newX = x + dir[0], newY = y + dir[1];
        if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY])
          continue;
        if (heightMap[newX][newY] < max)
          result += max - heightMap[newX][newY];
        visited[newX][newY] = true;
        queue.add(newX * n + newY);
      }
    }
    return result;
  }
}
// @lc code=end

