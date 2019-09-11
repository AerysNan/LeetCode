/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
  boolean[][] visited;
  int m, n;

  public boolean exist(char[][] board, String word) {
    if (board.length == 0 || board[0].length == 0)
      return false;
    m = board.length;
    n = board[0].length;
    visited = new boolean[m][n];
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0))
          return true;
    return false;
  }

  private boolean search(char[][] board, String word, int i, int j, int index) {
    if (index == word.length()) {
      return true;
    }
    if (i >= m || i < 0 || j >= n || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]) {
      return false;
    }
    visited[i][j] = true;
    if (search(board, word, i - 1, j, index + 1) || search(board, word, i + 1, j, index + 1)
        || search(board, word, i, j - 1, index + 1) || search(board, word, i, j + 1, index + 1))
      return true;
    visited[i][j] = false;
    return false;
  }
}
// @lc code=end

