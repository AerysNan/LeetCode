/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int n = numbers.length;
    if (n <= 1)
      return null;
    int l = 0, r = n - 1;
    while (l < r) {
      int value = numbers[l] + numbers[r];
      if (value == target)
        return new int[] {l + 1, r + 1};
      if (value < target)
        l++;
      else
        r--;
    }
    return null;
  }
}
// @lc code=end

