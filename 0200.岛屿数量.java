/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0)
      return 0;
    int m = grid.length, n = grid[0].length, result = 0;
    boolean[][] visited = new boolean[m][n];
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j] || grid[i][j] == '0')
          continue;
        result++;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(i * n + j);
        visited[i][j] = true;
        while (!queue.isEmpty()) {
          int value = queue.pollLast();
          int x = value / n, y = value % n;
          for (int k = 0; k < 4; k++) {
            int newX = x + dirs[k][0], newY = y + dirs[k][1];
            if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]
                || grid[newX][newY] == '0')
              continue;
            visited[newX][newY] = true;
            queue.add(newX * n + newY);
          }
        }
      }
    }
    return result;
  }
}
// @lc code=end

