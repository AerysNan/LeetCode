/*
 * @lc app=leetcode.cn id=1410 lang=java
 *
 * [1410] HTML 实体解析器
 */

// @lc code=start
class Solution {
  public String entityParser(String text) {
    StringBuilder result = new StringBuilder();
    char[] array = text.toCharArray();
    int n = array.length, i = 0;
    while (i < n) {
      if (array[i] != '&')
        result.append(array[i++]);
      else if (i + 6 <= n && text.substring(i, i + 6).equals("&quot;")) {
        result.append('\"');
        i += 6;
      } else if (i + 6 <= n && text.substring(i, i + 6).equals("&apos;")) {
        result.append('\'');
        i += 6;
      } else if (i + 5 <= n && text.substring(i, i + 5).equals("&amp;")) {
        result.append('&');
        i += 5;
      } else if (i + 7 <= n && text.substring(i, i + 7).equals("&frasl;")) {
        result.append('/');
        i += 7;
      } else if (i + 4 <= n && text.substring(i, i + 4).equals("&gt;")) {
        result.append('>');
        i += 4;
      } else if (i + 4 <= n && text.substring(i, i + 4).equals("&lt;")) {
        result.append('<');
        i += 4;
      } else
        result.append(array[i++]);
    }
    return result.toString();
  }
}
// @lc code=end

