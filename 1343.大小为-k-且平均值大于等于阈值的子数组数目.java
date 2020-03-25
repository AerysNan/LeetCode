/*
 * @lc app=leetcode.cn id=1343 lang=java
 *
 * [1343] 大小为 K 且平均值大于等于阈值的子数组数目
 */

// @lc code=start
import java.util.stream.IntStream;

class Solution {
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int total = k * threshold, n = arr.length;
    int sum = IntStream.range(0, k).map(x -> arr[x]).sum();
    int result = sum >= total ? 1 : 0;
    for (int i = 1; i <= n - k; i++) {
      sum += arr[i + k - 1] - arr[i - 1];
      result += sum >= total ? 1 : 0;
    }
    return result;
  }
}
// @lc code=end

