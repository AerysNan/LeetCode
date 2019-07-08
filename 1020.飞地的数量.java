import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */
class Solution {
  int[][] map;
  int[][] move = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  void bfs(int X, int Y) {
    LinkedList<int[]> list = new LinkedList<>();
    list.add(new int[] { X, Y });
    while (!list.isEmpty()) {
      int[] pair = list.pollLast();
      int x = pair[0];
      int y = pair[1];
      map[x][y] = 0;
      for (int i = 0; i < 4; i++) {
        int newX = x + move[i][0];
        int newY = y + move[i][1];
        if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length || map[newX][newY] == 0)
          continue;
        list.add(new int[] { newX, newY });
      }
    }
  }

  public int numEnclaves(int[][] A) {
    int m = A.length, n = A[0].length;
    map = new int[m + 2][n + 2];
    for (int i = 1; i <= m; i++)
      for (int j = 1; j <= n; j++)
        map[i][j] = A[i - 1][j - 1];
    for (int i = 0; i <= m + 1; i++) {
      map[i][0] = 1;
      map[i][n + 1] = 1;
    }
    for (int i = 0; i <= n + 1; i++) {
      map[0][i] = 1;
      map[m + 1][i] = 1;
    }
    bfs(0, 0);
    int result = 0;
    for (int i = 0; i <= m + 1; i++)
      for (int j = 0; j <= n + 1; j++)
        if (map[i][j] == 1)
          result++;
    return result;
  }
}
