/*
 * @lc app=leetcode.cn id=419 lang=java
 *
 * [419] 甲板上的战舰
 */

// @lc code=start
class Solution {
  public int countBattleships(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0)
      return 0;
    int result = 0, m = board.length, n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '.' || i > 0 && board[i - 1][j] == 'X'
            || j > 0 && board[i][j - 1] == 'X')
          continue;
        result++;
      }
    }
    return result;
  }
}
// @lc code=end

