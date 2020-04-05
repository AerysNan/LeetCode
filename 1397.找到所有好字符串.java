/*
 * @lc app=leetcode.cn id=5371 lang=java
 *
 * [5371] 找到所有好字符串
 */

// @lc code=start
class Solution {
  int[][] dp;
  int[] next;
  int mod = (int) 1e9 + 7;

  int[] getNext(String s) {
    int[] next = new int[s.length() + 1];
    int i = 0, j = -1;
    next[0] = -1;
    while (i < s.length()) {
      if (j == -1 || s.charAt(j) == s.charAt(i))
        next[++i] = ++j;
      else
        j = next[j];
    }
    next[0] = 0;
    return next;
  }

  int nextMatchPoint(char[] pattern, int index, char c) {
    while (index > 0 && pattern[index] != c)
      index = next[index];
    if (pattern[index] == c)
      index++;
    return index;
  }

  int dfs(char[] s, int index, char[] evil, int match, boolean threshold) {
    int n = s.length;
    if (index == n)
      return 1;
    if (!threshold && dp[index][match] != 0)
      return dp[index][match];
    char max = threshold ? s[index] : 'z';
    int result = 0;
    for (char c = 'a'; c <= max; c++) {
      if (evil[match] == c && match == evil.length - 1)
        continue;
      result += dfs(s, index + 1, evil, nextMatchPoint(evil, match, c), threshold && c == max);
      result %= mod;
    }
    if (!threshold)
      dp[index][match] = result;
    return result;
  }

  public int findGoodStrings(int n, String s1, String s2, String evil) {
    next = getNext(evil);
    dp = new int[s1.length()][evil.length()];
    int v1 = dfs(s1.toCharArray(), 0, evil.toCharArray(), 0, true);
    dp = new int[s2.length()][evil.length()];
    int v2 = dfs(s2.toCharArray(), 0, evil.toCharArray(), 0, true);
    return (v2 - v1 + (s1.contains(evil) ? 0 : 1) + mod) % mod;
  }
}
// @lc code=end

