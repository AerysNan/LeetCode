/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */
class Solution {
  public int firstMissingPositive(int[] nums) {
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      while (true) {
        if (nums[i] <= 0 || nums[i] >= length || nums[i] == i + 1 || nums[i] == nums[nums[i] - 1])
          break;
        int tmp = nums[i];
        nums[i] = nums[tmp - 1];
        nums[tmp - 1] = tmp;
      }
    }
    for (int i = 0; i < length; i++)
      if (nums[i] != i + 1)
        return i + 1;
    return length + 1;
  }
}
