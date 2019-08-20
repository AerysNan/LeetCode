/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
  int result = 0;

  public int totalNQueens(int n) {
    if (n == 0)
      return result;
    int[] pos = new int[n];
    solve(pos, 0);
    return result;
  }

  void solve(int[] pos, int index) {
    int n = pos.length;
    if (index == n) {
      result++;
      return;
    }
    for (int i = 0; i < n; i++) {
      boolean valid = true;
      for (int j = 0; j < index; j++) {
        if (pos[j] == i || Math.abs(index - j) == Math.abs(i - pos[j])) {
          valid = false;
          break;
        }
      }
      if (!valid)
        continue;
      pos[index] = i;
      solve(pos, index + 1);
    }
  }

}
// @lc code=end
