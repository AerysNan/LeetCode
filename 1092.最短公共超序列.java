/*
 * @lc app=leetcode.cn id=1092 lang=java
 *
 * [1092] 最短公共超序列
 */
class Solution {
  public String shortestCommonSupersequence(String str1, String str2) {
    int i = 0, j = 0;
    String result = "", s = lcs(str1, str2);
    for (int k = 0; k < s.length(); k++) {
      char c = s.charAt(k);
      while (str1.charAt(i) != c)
        result += str1.charAt(i++);
      while (str2.charAt(j) != c)
        result += str2.charAt(j++);
      result += c;
      i++;
      j++;
    }
    return result + str1.substring(i) + str2.substring(j);
  }

  String lcs(String str1, String str2) {
    int m = str1.length(), n = str2.length();
    String[][] dp = new String[m + 1][n + 1];
    for (int i = 0; i <= m; i++)
      for (int j = 0; j <= n; j++)
        dp[i][j] = "";
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (str1.charAt(i) == str2.charAt(j))
          dp[i + 1][j + 1] = dp[i][j] + str1.charAt(i);
        else
          dp[i + 1][j + 1] = dp[i + 1][j].length() > dp[i][j + 1].length() ? dp[i + 1][j] : dp[i][j + 1];
      }
    }
    return dp[m][n];
  }
}
