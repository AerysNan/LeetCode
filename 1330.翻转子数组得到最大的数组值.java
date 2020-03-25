/*
 * @lc app=leetcode.cn id=1330 lang=java
 *
 * [1330] 翻转子数组得到最大的数组值
 */

// @lc code=start
class Solution {
  public int maxValueAfterReverse(int[] nums) {
    int result = 0, n = nums.length;
    for (int i = 0; i < n - 1; i++)
      result += Math.abs(nums[i] - nums[i + 1]);
    int maxv = 0;
    for (int i = 0; i < n; i++) {
      if (i != n - 1)
        maxv = Math.max(maxv, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
      if (i != 0)
        maxv =
            Math.max(maxv, Math.abs(nums[n - 1] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]));
    }
    int[][] args = new int[][] {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    for (int i = 0; i < 4; i++) {
      int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
      for (int j = 0; j < n - 1; j++) {
        int v = args[i][0] * nums[j] + args[i][1] * nums[j + 1];
        int cur = Math.abs(nums[j] - nums[j + 1]);
        max = Math.max(max, v - cur);
        min = Math.min(min, v + cur);
      }
      maxv = Math.max(maxv, max - min);
    }
    return result + maxv;
  }
};
// @lc code=end

