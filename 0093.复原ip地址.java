/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
  List<String> result;

  public List<String> restoreIpAddresses(String s) {
    result = new ArrayList<>();
    dfs(s, 0, 4, "");
    return result;
  }

  void dfs(String s, int index, int num, String current) {
    if (num < 0)
      return;
    int n = s.length();
    if (index == n) {
      if (num == 0)
        result.add(current.substring(1));
      return;
    }
    for (int i = 1; i <= 3; i++) {
      if (index + i > n)
        continue;
      String sub = s.substring(index, index + i);
      if (i == 3 && Integer.parseInt(sub) > 255)
        break;
      dfs(s, index + i, num - 1, current + "." + sub);
      if (s.charAt(index) == '0')
        break;
    }
  }
}
// @lc code=end

