/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */
class Solution {
  public boolean isMatch(String s, String p) {
    int m = s.length(), n = p.length();
    boolean[][] match = new boolean[m + 1][n + 1];
    match[0][0] = true;
    int index = 1;
    while (true) {
      if (index >= n || p.charAt(index) != '*')
        break;
      match[0][index + 1] = true;
      index += 2;
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))
          match[i + 1][j + 1] = match[i][j];
        else if (p.charAt(j) == '*') {
          if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.')
            match[i + 1][j + 1] = match[i + 1][j - 1];
          else
            match[i + 1][j + 1] = match[i][j + 1] || match[i + 1][j] || match[i + 1][j - 1];
        }
      }
    }
    return match[m][n];
  }
}
