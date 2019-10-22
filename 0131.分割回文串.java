/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  List<List<String>> result;

  public List<List<String>> partition(String s) {
    result = new ArrayList<>();
    if (s.length() == 0)
      return result;
    dfs(s, 0, s.length(), new LinkedList<>());
    return result;

  }

  void dfs(String s, int l, int r, LinkedList<String> current) {
    if (l == r) {
      result.add(new LinkedList<>(current));
      return;
    }
    for (int i = l + 1; i <= r; i++) {
      if (!isPalindrome(s, l, i))
        continue;
      current.addLast(s.substring(l, i));
      dfs(s, i, r, current);
      current.pollLast();
    }
  }

  boolean isPalindrome(String s, int l, int r) {
    int n = (r - l) / 2;
    for (int i = 0; i < n; i++)
      if (s.charAt(i + l) != s.charAt(r - 1 - i))
        return false;
    return true;
  }
}
// @lc code=end

