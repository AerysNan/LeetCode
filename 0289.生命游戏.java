/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
  public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0)
      return;
    int m = board.length, n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int lives = liveNeighbors(board, i, j);
        if (board[i][j] == 1 && lives >= 2 && lives <= 3)
          board[i][j] = 3;
        if (board[i][j] == 0 && lives == 3)
          board[i][j] = 2;
      }
    }
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        board[i][j] >>= 1;
  }

  public int liveNeighbors(int[][] board, int i, int j) {
    int result = 0, m = board.length, n = board[0].length;
    for (int x = i - 1; x <= i + 1; x++) {
      for (int y = j - 1; y <= j + 1; y++) {
        if (x < 0 || x >= m || y < 0 || y >= n)
          continue;
        result += board[x][y] & 1;
      }
    }
    result -= board[i][j] & 1;
    return result;
  }
}
// @lc code=end

