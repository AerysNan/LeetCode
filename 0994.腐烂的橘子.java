/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
  public int orangesRotting(int[][] grid) {
    LinkedList<Integer> queue = new LinkedList<>();
    int m = grid.length, n = grid[0].length, result = 0, fresh = 0;
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2)
          queue.offer(i * n + j);
        else if (grid[i][j] == 1)
          fresh++;
      }
    }
    while (fresh > 0 && !queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int next = queue.poll(), x = next / n, y = next % n;
        for (int[] dir : dirs) {
          int newX = x + dir[0], newY = y + dir[1];
          if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 1)
            continue;
          grid[newX][newY] = 2;
          fresh--;
          queue.offer(newX * n + newY);
        }
      }
      result++;
    }
    return fresh > 0 ? -1 : result;
  }
}
// @lc code=end
