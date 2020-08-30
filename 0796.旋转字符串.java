/*
 * @lc app=leetcode.cn id=796 lang=java
 *
 * [796] 旋转字符串
 */

// @lc code=start
class Solution {
  public boolean rotateString(String A, String B) {
    return A.length() == B.length() && new StringBuilder(A).append(A).toString().contains(B);
  }
}
// @lc code=end
