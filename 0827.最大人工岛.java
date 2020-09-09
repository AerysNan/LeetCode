/*
 * @lc app=leetcode.cn id=827 lang=java
 *
 * [827] 最大人工岛
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
  int n;
  int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }, grid;

  public int largestIsland(int[][] grid) {
    this.grid = grid;
    n = grid.length;
    int index = 2;
    int[] area = new int[n * n + 2];
    for (int x = 0; x < n; x++)
      for (int y = 0; y < n; y++)
        if (grid[x][y] == 1)
          area[index] = dfs(x, y, index++);
    int result = 0;
    for (int x : area)
      result = Math.max(result, x);
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < n; y++) {
        if (grid[x][y] != 0)
          continue;
        HashSet<Integer> seen = new HashSet<>();
        for (int next : neighbors(x, y))
          if (grid[next / n][next % n] > 1)
            seen.add(grid[next / n][next % n]);
        int sum = 1;
        for (int i : seen)
          sum += area[i];
        result = Math.max(result, sum);
      }
    }
    return result;
  }

  public int dfs(int r, int c, int index) {
    int result = 1;
    grid[r][c] = index;
    for (int next : neighbors(r, c)) {
      if (grid[next / n][next % n] == 1) {
        grid[next / n][next % n] = index;
        result += dfs(next / n, next % n, index);
      }
    }
    return result;
  }

  public ArrayList<Integer> neighbors(int x, int y) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int[] dir : dirs) {
      int newX = x + dir[0], newY = y + dir[1];
      if (newX >= 0 && newX < n && newY >= 0 && newY < n)
        result.add(newX * n + newY);
    }
    return result;
  }
}
// @lc code=end
