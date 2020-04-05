/*
 * @lc app=leetcode.cn id=5366 lang=java
 *
 * [5366] 检查网格中是否存在有效路径
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
  int[][][] dirs = new int[][][] {{{0, 1}, {0, -1}}, {{1, 0}, {-1, 0}}, {{0, -1}, {1, 0}},
      {{0, 1}, {1, 0}}, {{-1, 0}, {0, -1}}, {{-1, 0}, {0, 1}}};

  public boolean hasValidPath(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    visited[0][0] = true;
    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(0);
    while (!queue.isEmpty()) {

      int pos = queue.poll(), x = pos / n, y = pos % n, index = grid[x][y] - 1;
      for (int[] dir : dirs[index]) {
        int newX = x + dir[0], newY = y + dir[1];
        if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY])
          continue;
        if (!valid(dir, grid[newX][newY]))
          continue;
        visited[newX][newY] = true;
        queue.add(newX * n + newY);
      }
    }
    return visited[m - 1][n - 1];
  }

  boolean valid(int[] dir, int index) {
    if (dir[0] == 0) {
      if (dir[1] == -1) {
        return index == 1 || index == 4 || index == 6;
      } else if (dir[1] == 1) {
        return index == 1 || index == 3 || index == 5;
      }
    } else if (dir[0] == -1) {
      return index == 2 || index == 3 || index == 4;
    } else if (dir[0] == 1) {
      return index == 2 || index == 5 || index == 6;
    }
    return false;
  }
}
// @lc code=end

