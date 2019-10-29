/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
import java.util.HashSet;
import java.util.List;

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0)
      return false;
    HashSet<String> dict = new HashSet<>(wordDict);
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (dict.contains(s.substring(j, i)) && dp[j]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }
}
// @lc code=end

