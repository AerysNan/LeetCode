import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1034 lang=java
 *
 * [1034] 边框着色
 */
class Solution {
  int[][] dir = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

  public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
    int R = grid.length, C = grid[0].length;
    boolean[][] visited = new boolean[R][C];
    ArrayList<Integer> toPaint = new ArrayList<>();
    LinkedList<Integer> queue = new LinkedList<>();
    visited[r0][c0] = true;
    int value = grid[r0][c0];
    queue.addLast((r0 << 6) + c0);
    while (!queue.isEmpty()) {
      int pos = queue.pollFirst();
      int r = pos >> 6, c = pos & 0x3f;
      boolean border = false;
      if (r == 0 || r == R - 1 || c == 0 || c == C - 1)
        border = true;
      for (int i = 0; i < 4; i++) {
        int newR = r + dir[i][0], newC = c + dir[i][1];
        if (newR < 0 || newR >= R || newC < 0 || newC >= C || visited[newR][newC])
          continue;
        if (grid[newR][newC] == value) {
          visited[newR][newC] = true;
          queue.add((newR << 6) + newC);
        } else
          border = true;
      }
      if (border)
        toPaint.add(pos);
    }
    for (int pos : toPaint)
      grid[pos >> 6][pos & 0x3f] = color;
    return grid;
  }
}
