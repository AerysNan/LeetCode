import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1030 lang=java
 *
 * [1030] 距离顺序排列矩阵单元格
 */
class Solution {
  int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    int index = 0;
    int[][] result = new int[R * C][2];
    LinkedList<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[R][C];
    queue.addLast(new int[] { r0, c0 });
    visited[r0][c0] = true;
    while (!queue.isEmpty()) {
      int[] pos = queue.pollFirst();
      result[index][0] = pos[0];
      result[index++][1] = pos[1];
      for (int i = 0; i < 4; i++) {
        int newRow = pos[0] + dir[i][0];
        int newCol = pos[1] + dir[i][1];
        if (newRow >= 0 && newRow < R && newCol >= 0 && newCol < C && !visited[newRow][newCol]) {
          visited[newRow][newCol] = true;
          queue.addLast(new int[] { newRow, newCol });
        }
      }
    }
    return result;
  }
}
