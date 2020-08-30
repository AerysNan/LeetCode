/*
 * @lc app=leetcode.cn id=798 lang=java
 *
 * [798] 得分最高的最小轮调
 */

// @lc code=start
class Solution {
  public int bestRotation(int[] A) {
    int n = A.length;
    int[] bad = new int[n];
    for (int i = 0; i < n; ++i) {
      int l = (i - A[i] + 1 + n) % n, r = (i + 1) % n;
      bad[l]++;
      bad[r]--;
      if (l > r)
        bad[0]++;
    }

    int best = n;
    int result = 0, current = 0;
    for (int i = 0; i < n; ++i) {
      current += bad[i];
      if (current < best) {
        best = current;
        result = i;
      }
    }
    return result;
  }
}
// @lc code=end
