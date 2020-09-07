/*
 * @lc app=leetcode.cn id=826 lang=java
 *
 * [826] 安排工作以达到最大收益
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int n = difficulty.length, result = 0, index = 0, best = 0;
    int[][] jobs = new int[n][2];
    for (int i = 0; i < n; i++)
      jobs[i] = new int[] { difficulty[i], profit[i] };
    Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
    Arrays.sort(worker);
    for (int skill : worker) {
      while (index < n && skill >= jobs[index][0])
        best = Math.max(best, jobs[index++][1]);
      result += best;
    }
    return result;
  }
}
// @lc code=end
