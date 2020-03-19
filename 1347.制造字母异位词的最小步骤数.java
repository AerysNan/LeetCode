/*
 * @lc app=leetcode.cn id=1347 lang=java
 *
 * [1347] 制造字母异位词的最小步骤数
 */

// @lc code=start
class Solution {
  public int minSteps(String s, String t) {
    int[] count = new int[26];
    for (char c : s.toCharArray())
      count[c - 'a']++;
    int result = 0;
    for (char c : t.toCharArray()) {
      if (count[c - 'a'] == 0)
        result++;
      else
        count[c - 'a']--;
    }
    return result;
  }
}
// @lc code=end

