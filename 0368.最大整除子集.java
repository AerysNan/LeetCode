/*
 * @lc app=leetcode.cn id=368 lang=java
 *
 * [368] 最大整除子集
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n], prev = new int[n];
    Arrays.sort(nums);
    int index = -1;
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      prev[i] = -1;
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] % nums[j] != 0)
          continue;
        if (dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
          prev[i] = j;
        }
      }
      if (index < 0 || dp[i] > dp[index])
        index = i;
    }
    List<Integer> result = new ArrayList<>();
    while (index != -1) {
      result.add(nums[index]);
      index = prev[index];
    }
    return result;
  }
}
// @lc code=end

