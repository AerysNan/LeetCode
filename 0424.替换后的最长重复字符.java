/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class Solution {
  public int characterReplacement(String s, int k) {
    int maxCount = 0, result = 0, length = s.length(), l = 0, r = 0;
    int[] count = new int[26];
    while (r < length) {
      maxCount = Math.max(maxCount, ++count[s.charAt(r) - 'A']);
      if (r - l + 1 - maxCount > k)
        count[s.charAt(l++) - 'A']--;
      result = Math.max(result, r++ - l + 1);
    }
    return result;
  }
}
// @lc code=end

