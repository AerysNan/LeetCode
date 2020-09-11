/*
 * @lc app=leetcode.cn id=997 lang=java
 *
 * [997] 找到小镇的法官
 */

// @lc code=start
class Solution {
  public int findJudge(int N, int[][] trust) {
    int[] in = new int[N], out = new int[N];
    for (int[] t : trust) {
      out[t[0] - 1]++;
      in[t[1] - 1]++;
    }
    for (int i = 0; i < N; i++)
      if (in[i] == N - 1 && out[i] == 0)
        return i + 1;
    return -1;
  }
}
// @lc code=end
