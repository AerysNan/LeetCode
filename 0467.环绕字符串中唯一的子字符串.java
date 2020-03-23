/*
 * @lc app=leetcode.cn id=467 lang=java
 *
 * [467] 环绕字符串中唯一的子字符串
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int findSubstringInWraproundString(String p) {
    int[] m = new int[26];
    char[] c = p.toCharArray();
    int n = c.length, l = 0;
    for (int i = 0; i < n; i++) {
      if (i > 0 && (c[i - 1] == 'z' && c[i] == 'a' || c[i] == c[i - 1] + 1))
        l++;
      else
        l = 1;
      m[c[i] - 'a'] = Math.max(m[c[i] - 'a'], l);
    }
    return Arrays.stream(m).sum();
  }
}
// @lc code=end

