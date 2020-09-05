/*
 * @lc app=leetcode.cn id=816 lang=java
 *
 * [816] 模糊坐标
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<String> ambiguousCoordinates(String S) {
    List<String> result = new ArrayList<>();
    for (int i = 2; i < S.length() - 1; i++)
      for (String left : make(S, 1, i))
        for (String right : make(S, i, S.length() - 1))
          result.add(new StringBuilder().append('(').append(left).append(", ").append(right).append(')').toString());
    return result;
  }

  public List<String> make(String S, int i, int j) {
    List<String> result = new ArrayList<>();
    for (int d = 1; d <= j - i; d++) {
      String left = S.substring(i, i + d);
      String right = S.substring(i + d, j);
      if ((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0"))
        result.add(new StringBuilder().append(left).append(d < j - i ? "." : "").append(right).toString());
    }
    return result;
  }
}
// @lc code=end
