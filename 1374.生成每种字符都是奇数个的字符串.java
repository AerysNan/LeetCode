/*
 * @lc app=leetcode.cn id=1374 lang=java
 *
 * [1374] 生成每种字符都是奇数个的字符串
 */

// @lc code=start
class Solution {
  public String generateTheString(int n) {
    StringBuilder stringBuilder = new StringBuilder();
    if (n % 2 == 0) {
      for (int i = 0; i < n - 1; i++)
        stringBuilder.append('a');
      stringBuilder.append('b');
    } else
      for (int i = 0; i < n; i++)
        stringBuilder.append('a');
    return stringBuilder.toString();
  }
}
// @lc code=end

