/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0, j = 0, result = 0;
    while (i < g.length && j < s.length) {
      if (g[i] <= s[j]) {
        i++;
        j++;
        result++;
      } else
        j++;
    }
    return result;
  }
}
// @lc code=end

