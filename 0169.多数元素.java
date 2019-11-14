/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
  public int majorityElement(int[] nums) {
    int result = nums[0], count = 0;
    for (int num : nums) {
      if (num == result)
        count++;
      else if (count > 0)
        count--;
      else {
        count = 1;
        result = num;
      }
    }
    return result;
  }
}
// @lc code=end

