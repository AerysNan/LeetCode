/*
 * @lc app=leetcode.cn id=457 lang=java
 *
 * [457] 环形数组循环
 */

// @lc code=start
class Solution {
  private void setZero(int[] nums, int index) {
    while (true) {
      int next = (index + nums[index] + 5000 * nums.length) % nums.length;
      if (nums[next] == 0 || nums[index] * nums[next] < 0) {
        nums[index] = 0;
        break;
      }
      nums[index] = 0;
      index = next;
    }
  }

  public boolean circularArrayLoop(int[] nums) {
    if (nums.length == 0)
      return false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0)
        continue;
      int currentSlow = i, currentFast = i;
      while (true) {
        int prevSlow = currentSlow;
        currentSlow = (currentSlow + nums[currentSlow] + 5000 * nums.length) % nums.length;
        if (nums[prevSlow] * nums[currentSlow] < 0 || nums[currentSlow] == 0
            || prevSlow == currentSlow) {
          setZero(nums, i);
          break;
        }
        int prevFast = currentFast;
        currentFast = (currentFast + nums[currentFast] + 5000 * nums.length) % nums.length;
        if (nums[prevFast] * nums[currentFast] < 0 || nums[currentFast] == 0
            || prevFast == currentFast) {
          setZero(nums, i);
          break;
        }
        prevFast = currentFast;
        currentFast = (currentFast + nums[currentFast] + 5000 * nums.length) % nums.length;
        if (nums[prevFast] * nums[currentFast] < 0 || nums[currentFast] == 0
            || prevFast == currentFast) {
          setZero(nums, i);
          break;
        }
        if (currentSlow == currentFast)
          return true;
      }
    }
    return false;
  }
}
// @lc code=end

