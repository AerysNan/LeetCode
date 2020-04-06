/*
 * @lc app=leetcode.cn id=1189 lang=java
 *
 * [1189] “气球” 的最大数量
 */

// @lc code=start
class Solution {
  public int maxNumberOfBalloons(String text) {
    int[] count = new int[26];
    for (char c : text.toCharArray())
      count[c - 'a']++;
    int result = Integer.MAX_VALUE;
    result = Math.min(result, count[0]);
    result = Math.min(result, count[1]);
    result = Math.min(result, count[11] / 2);
    result = Math.min(result, count[13]);
    result = Math.min(result, count[14] / 2);
    return result;
  }
}
// @lc code=end

