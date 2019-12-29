/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> removeInvalidParentheses(String s) {
    List<String> output = new ArrayList<>();
    helper(s, output, 0, 0, '(', ')');
    return output;
  }

  public void helper(String s, List<String> output, int iStart, int jStart, char openParen,
      char closedParen) {
    int count = 0;
    for (int i = iStart; i < s.length(); i++) {
      if (s.charAt(i) == openParen)
        count++;
      if (s.charAt(i) == closedParen)
        count--;
      if (count >= 0)
        continue;
      for (int j = jStart; j <= i; j++)
        if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen))
          helper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen,
              closedParen);
      return;
    }
    String reversed = new StringBuilder(s).reverse().toString();
    if (openParen == '(')
      helper(reversed, output, 0, 0, ')', '(');
    else
      output.add(reversed);
  }
}
// @lc code=end

