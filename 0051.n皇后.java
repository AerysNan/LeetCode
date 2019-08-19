/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;

class Solution {
  List<List<String>> result;

  public List<List<String>> solveNQueens(int n) {
    result = new ArrayList<>();
    if (n == 0)
      return result;
    int[] pos = new int[n];
    solve(pos, 0);
    return result;
  }

  void solve(int[] pos, int index) {
    int n = pos.length;
    if (index == n) {
      addSolution(pos);
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

  void addSolution(int[] pos) {
    int n = pos.length;
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < pos[i]; j++)
        sb.append('.');
      sb.append('Q');
      for (int j = pos[i] + 1; j < n; j++)
        sb.append('.');
      list.add(sb.toString());
    }
    result.add(list);
  }
}
// @lc code=end
