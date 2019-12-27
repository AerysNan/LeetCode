/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    for (int i = 0, acc = 1; i < n; acc *= nums[i++])
      result[i] = acc;
    for (int i = n - 1, acc = 1; i >= 0; acc *= nums[i--])
      result[i] *= acc;
    return result;
  }
}
// @lc code=end

