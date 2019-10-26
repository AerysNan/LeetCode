/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int candy(int[] ratings) {
    int n = ratings.length;
    if (n <= 1)
      return n;
    int[] count = new int[n];
    Arrays.fill(count, 1);
    for (int i = 1; i < n; i++)
      if (ratings[i] > ratings[i - 1])
        count[i] = count[i - 1] + 1;
    for (int i = n - 1; i >= 1; i--)
      if (ratings[i - 1] > ratings[i])
        count[i - 1] = Math.max(count[i - 1], count[i] + 1);
    int result = 0;
    for (int value : count)
      result += value;
    return result;
  }
}
// @lc code=end

