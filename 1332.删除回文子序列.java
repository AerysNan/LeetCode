/*
 * @lc app=leetcode.cn id=1332 lang=java
 *
 * [1332] 删除回文子序列
 */

// @lc code=start
class Solution {
  public int removePalindromeSub(String s) {
    if (s.length() == 0)
      return 0;
    StringBuilder stringBuilder = new StringBuilder(s);
    return stringBuilder.reverse().toString().equals(s) ? 1 : 2;
  }
}
// @lc code=end

