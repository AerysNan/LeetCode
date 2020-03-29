/*
 * @lc app=leetcode.cn id=1162 lang=java
 *
 * [1162] 地图分析
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
  public int maxDistance(int[][] grid) {
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    LinkedList<Integer> queue = new LinkedList<>();
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (grid[i][j] == 1)
          queue.addFirst(i * n + j);
    if (queue.size() == 0 || queue.size() == m * n)
      return -1;
    int result = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int pos = queue.pollLast(), x = pos / n, y = pos % n;
        for (int[] dir : dirs) {
          int newX = x + dir[0], newY = y + dir[1];
          if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 1)
            continue;
          grid[newX][newY] = 1;
          queue.addFirst(newX * n + newY);
        }
      }
      result++;
    }
    return result - 1;
  }
}
// @lc code=end

