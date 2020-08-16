/*
 * @lc app=leetcode.cn id=778 lang=java
 *
 * [778] 水位上升的泳池中游泳
 */

// @lc code=start
import java.util.PriorityQueue;

class Solution {
  public int swimInWater(int[][] grid) {
    int N = grid.length;
    boolean[][] visited = new boolean[N][N];
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>((k1, k2) -> grid[k1 / N][k1 % N] - grid[k2 / N][k2 % N]);
    queue.offer(0);
    int result = 0;
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    while (!queue.isEmpty()) {
      int k = queue.poll();
      int x = k / N, y = k % N;
      result = Math.max(result, grid[x][y]);
      if (x == N - 1 && y == N - 1)
        return result;
      for (int[] dir : dirs) {
        int newX = x + dir[0], newY = y + dir[1];
        if (newX < 0 || newX >= N || newY < 0 || newY >= N || visited[newX][newY])
          continue;
        queue.offer(newX * N + newY);
        visited[newX][newY] = true;
      }
    }
    return 0;
  }
}
// @lc code=end
