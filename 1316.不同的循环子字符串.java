/*
 * @lc app=leetcode.cn id=1316 lang=java
 *
 * [1316] 不同的循环子字符串
 */

// @lc code=start
import java.util.HashSet;

class Solution {
  public int distinctEchoSubstrings(String text) {
    int n = text.length();
    HashSet<String> set = new HashSet<>();
    int result = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        int l = j - i;
        if (j * 2 - i <= n && text.substring(i, i + l).equals(text.substring(j, j + l))
            && !set.contains(text.substring(i, i + l))) {
          result++;
          set.add(text.substring(i, i + l));
        }
      }
    }
    return result;
  }
}
// @lc code=end

