/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 */

// @lc code=start
class Solution {
  public int maxProduct(int[] nums) {
    int max = 1, min = 1, result = Integer.MIN_VALUE;
    for (int num : nums) {
      int tmp = Math.max(num, Math.max(max * num, min * num));
      min = Math.min(num, Math.min(max * num, min * num));
      max = tmp;
      result = Math.max(result, max);
    }
    return result;
  }
}
// @lc code=end

