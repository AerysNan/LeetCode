/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
  private int compute(int l, int r, char c) {
    switch (c) {
      case '+':
        return l + r;
      case '-':
        return l - r;
      case '*':
        return l * r;
      default:
        return 0;
    }
  }

  public List<Integer> diffWaysToCompute(String input) {
    int n = input.length();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      char c = input.charAt(i);
      if (c != '+' && c != '-' && c != '*')
        continue;
      List<Integer> ls = diffWaysToCompute(input.substring(0, i));
      List<Integer> rs = diffWaysToCompute(input.substring(i + 1, n));
      for (int l : ls)
        for (int r : rs)
          result.add(compute(l, r, c));
    }
    if (result.isEmpty())
      result.add(Integer.parseInt(input));
    return result;
  }
}
// @lc code=end

