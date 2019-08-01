/*
 * @lc app=leetcode.cn id=1144 lang=java
 *
 * [1144] 递减元素使数组呈锯齿状
 */
class Solution {
  public int movesToMakeZigzag(int[] nums) {
    int count1 = 0, count2 = 0, n = nums.length;
    if (n == 1)
      return 0;
    for (int i = 0; i < n; i += 2) {
      int value = Math.min(i - 1 >= 0 ? nums[i - 1] : 1001, i + 1 < n ? nums[i + 1] : 1001);
      count1 += nums[i] < value ? 0 : (nums[i] - value + 1);
    }
    for (int i = 1; i < n; i += 2) {
      int value = Math.min(i - 1 >= 0 ? nums[i - 1] : 1001, i + 1 < n ? nums[i + 1] : 1001);
      count2 += nums[i] < value ? 0 : (nums[i] - value + 1);
    }
    return Math.min(count1, count2);
  }
}
