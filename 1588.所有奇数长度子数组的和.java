/*
 * @lc app=leetcode.cn id=1588 lang=java
 *
 * [1588] 所有奇数长度子数组的和
 */

// @lc code=start
class Solution {
  public int sumOddLengthSubarrays(int[] arr) {
    int n = arr.length, result = 0;
    int[] sum = new int[n + 1];
    for (int i = 1; i <= n; i++)
      sum[i] = sum[i - 1] + arr[i - 1];
    for (int length = 1; length <= n; length += 2)
      for (int i = 0; i <= n - length; i++)
        result += sum[i + length] - sum[i];
    return result;
  }
}
// @lc code=end
