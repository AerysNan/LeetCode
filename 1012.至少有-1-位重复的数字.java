/*
 * @lc app=leetcode.cn id=1012 lang=java
 *
 * [1012] 至少有 1 位重复的数字
 */

// @lc code=start

class Solution {
  int result;

  public int numDupDigitsAtMostN(int N) {
    search(N, new boolean[10], 0);
    return N - result;
  }

  void search(long N, boolean[] pick, long current) {
    for (int i = 0; i <= 9; i++) {
      if (pick[i] || current * 10 + i > N || (i == 0 && current == 0))
        continue;
      result++;
      pick[i] = true;
      search(N, pick, current * 10 + i);
      pick[i] = false;
    }
  }
}
// @lc code=end

