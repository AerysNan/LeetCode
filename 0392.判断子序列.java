/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
  public boolean isSubsequence(String s, String t) {
    int index1 = 0, index2 = 0;
    while (index1 < s.length() && index2 < t.length())
      if (s.charAt(index1) == t.charAt(index2++))
        index1++;
    return index1 == s.length();
  }
}
// @lc code=end

