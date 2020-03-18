/*
 * @lc app=leetcode.cn id=999 lang=java
 *
 * [999] 车的可用捕获量
 */

// @lc code=start
class Solution {
  public int numRookCaptures(char[][] board) {
    int result = 0, m = board.length, n = board[0].length;
    int x = -1, y = -1;
    loop: for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'R') {
          x = i;
          y = j;
          break loop;
        }
      }
    }
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int[] dir : dirs) {
      int posX = x, posY = y;
      while (true) {
        posX += dir[0];
        posY += dir[1];
        if (posX < 0 || posX >= m || posY < 0 || posY >= n)
          break;
        if (board[posX][posY] == 'B')
          break;
        if (board[posX][posY] == 'p') {
          result++;
          break;
        }
      }
    }
    return result;
  }
}
// @lc code=end

