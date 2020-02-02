/*
 * @lc app=leetcode.cn id=423 lang=java
 *
 * [423] 从英文中重建数字
 */

// @lc code=start
class Solution {
  public String originalDigits(String s) {
    StringBuilder result = new StringBuilder();
    int[] counts = new int[26 + 'a'], nums = new int[10];
    for (char c : s.toCharArray())
      counts[c]++;
    nums[0] = counts['z'];
    nums[2] = counts['w'];
    nums[4] = counts['u'];
    nums[6] = counts['x'];
    nums[8] = counts['g'];
    nums[1] = counts['o'] - nums[0] - nums[2] - nums[4];
    nums[3] = counts['h'] - nums[8];
    nums[5] = counts['f'] - nums[4];
    nums[7] = counts['s'] - nums[6];
    nums[9] = counts['i'] - nums[6] - nums[8] - nums[5];
    for (int i = 0; i < nums.length; i++)
      for (int j = 0; j < nums[i]; j++)
        result.append(i);
    return result.toString();
  }
}
// @lc code=end

