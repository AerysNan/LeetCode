/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
import java.util.LinkedList;

class Point {
  int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}


class Solution {
  public void solve(char[][] board) {
    int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    if (board.length == 0 || board[0].length == 0)
      return;
    int m = board.length, n = board[0].length;
    boolean[][] edge = new boolean[m][n];
    LinkedList<Point> queue = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O')
        queue.addFirst(new Point(i, 0));
      if (board[i][n - 1] == 'O')
        queue.addFirst(new Point(i, n - 1));
    }
    for (int i = 0; i < n; i++) {
      if (board[0][i] == 'O')
        queue.addFirst(new Point(0, i));
      if (board[m - 1][i] == 'O')
        queue.addFirst(new Point(m - 1, i));
    }
    while (!queue.isEmpty()) {
      Point p = queue.pollLast();
      if (edge[p.x][p.y])
        continue;
      edge[p.x][p.y] = true;
      for (int i = 0; i < 4; i++) {
        int X = p.x + dir[i][0], Y = p.y + dir[i][1];
        if (X < 0 || X >= m || Y < 0 || Y >= n)
          continue;
        if (board[X][Y] == 'X' || edge[X][Y])
          continue;
        queue.addFirst(new Point(X, Y));
      }
    }
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (board[i][j] == 'O' && !edge[i][j])
          board[i][j] = 'X';
  }
}
// @lc code=end

