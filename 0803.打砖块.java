/*
 * @lc app=leetcode.cn id=803 lang=java
 *
 * [803] 打砖块
 */

// @lc code=start
import java.util.Arrays;
import java.util.stream.IntStream;

class UFS {
  int[] parent;
  int[] size;

  public UFS(int n) {
    parent = IntStream.range(0, n).toArray();
    size = new int[n];
    Arrays.fill(size, 1);
  }

  public int find(int x) {
    if (parent[x] != x)
      parent[x] = find(parent[x]);
    return parent[x];
  }

  public void union(int x, int y) {
    int xp = find(x), yp = find(y);
    if (xp == yp)
      return;
    parent[xp] = yp;
    size[yp] += size[xp];
  }

  public int connected() {
    return size[find(size.length - 1)] - 1;
  }
}

class Solution {
  public int[] hitBricks(int[][] grid, int[][] hits) {
    int m = grid.length, n = grid[0].length, c = hits.length;
    int[][] map = new int[m][n], dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
    for (int i = 0; i < m; i++)
      map[i] = grid[i].clone();
    for (int[] hit : hits)
      map[hit[0]][hit[1]] = 0;
    UFS set = new UFS(m * n + 1);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 0)
          continue;
        int value = i * n + j;
        if (i == 0)
          set.union(value, m * n);
        if (i > 0 && map[i - 1][j] == 1)
          set.union(value, (i - 1) * n + j);
        if (j > 0 && map[i][j - 1] == 1)
          set.union(value, i * n + j - 1);
      }
    }
    int[] result = new int[c];
    for (int i = c - 1; i >= 0; i--) {
      int x = hits[i][0], y = hits[i][1];
      if (grid[x][y] == 0)
        continue;
      int prev = set.connected();
      for (int[] dir : dirs) {
        int newX = x + dir[0], newY = y + dir[1];
        if (newX >= 0 && newX < m && newY >= 0 && newY < n && map[newX][newY] == 1)
          set.union(x * n + y, newX * n + newY);
      }
      if (x == 0)
        set.union(x * n + y, m * n);
      map[x][y] = 1;
      result[i] = Math.max(0, set.connected() - prev - 1);
    }
    return result;
  }
}
// @lc code=end
