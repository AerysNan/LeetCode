/*
 * @lc app=leetcode.cn id=5369 lang=java
 *
 * [5369] 统计作战单位数
 */

// @lc code=start
class Solution {
  public int numTeams(int[] rating) {
    int n = rating.length, result = 0;
    for (int i = 0; i <= n - 3; i++)
      for (int j = i + 1; j <= n - 2; j++)
        for (int k = j + 1; k <= n - 1; k++)
          if (rating[i] < rating[j] && rating[j] < rating[k]
              || rating[i] > rating[j] && rating[j] > rating[k])
            result++;
    return result;
  }
}
// @lc code=end

