/*
 * @lc app=leetcode.cn id=1191 lang=java
 *
 * [1191] K 次串联后最大子数组之和
 */

// @lc code=start
class Solution {
  public int kConcatenationMaxSum(int[] arr, int k) {
    if (arr == null || arr.length == 0)
      return 0;
    long maxOfEnd = arr[0] > 0 ? arr[0] : 0, maxSoFar = maxOfEnd, sum = arr[0];
    for (int i = 1; i < Math.min(k, 2) * arr.length; i++) {
      maxOfEnd = Math.max(maxOfEnd + arr[i % arr.length], arr[i % arr.length]);
      maxSoFar = Math.max(maxOfEnd, maxSoFar);
      if (i < arr.length)
        sum += arr[i];
    }
    while (sum > 0 && --k >= 2)
      maxSoFar = (maxSoFar + sum) % 1000000007;
    return (int) maxSoFar;
  }
}
// @lc code=end

