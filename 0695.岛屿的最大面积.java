/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
  int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int maxAreaOfIsland(int[][] grid) {
    int result = 0, m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0)
          continue;
        int current = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(i * n + j);
        grid[i][j] = 0;
        while (!queue.isEmpty()) {
          int pos = queue.pollLast(), x = pos / n, y = pos % n;
          current++;
          for (int[] dir : dirs) {
            int newX = x + dir[0], newY = y + dir[1];
            if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 0)
              continue;
            grid[newX][newY] = 0;
            queue.addFirst(newX * n + newY);
          }
        }
        result = Math.max(result, current);
      }
    }
    return result;
  }
}
// @lc code=end

