/*
 * @lc app=leetcode.cn id=330 lang=java
 *
 * [330] 按要求补齐数组
 */

// @lc code=start
class Solution {
  public int minPatches(int[] nums, int n) {
    int length = nums.length, index = 0, result = 0;
    long sum = 0;
    while (sum < n) {
      if (index == length || sum + 1 < nums[index]) {
        result++;
        sum = (sum << 1) + 1;
      } else
        sum += nums[index++];
    }
    return result;
  }
}
// @lc code=end

