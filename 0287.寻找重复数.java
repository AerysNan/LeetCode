/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
  public int findDuplicate(int[] nums) {
    if (nums.length <= 1)
      return -1;
    int slow = 0, fast = 0;
    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast)
        break;
    }
    int result = 0;
    while (result != slow) {
      result = nums[result];
      slow = nums[slow];
    }
    return result;
  }
}
// @lc code=end

