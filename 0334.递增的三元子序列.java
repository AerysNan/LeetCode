/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
  public boolean increasingTriplet(int[] nums) {
    if (nums.length < 3)
      return false;
    int v1 = Integer.MAX_VALUE, v2 = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num <= v1)
        v1 = num;
      else if (num <= v2)
        v2 = num;
      else
        return true;
    }
    return false;
  }
}
// @lc code=end

