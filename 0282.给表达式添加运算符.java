/*
 * @lc app=leetcode.cn id=282 lang=java
 *
 * [282] 给表达式添加运算符
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> addOperators(String num, int target) {
    List<String> result = new ArrayList<String>();
    if (num == null || num.length() == 0)
      return result;
    search(result, "", num, target, 0, 0, 0);
    return result;
  }

  public void search(List<String> result, String current, String string, int target, int index,
      long value, long prev) {
    if (index == string.length()) {
      if (target == value)
        result.add(current);
      return;
    }
    for (int i = index; i < string.length(); i++) {
      if (i != index && string.charAt(index) == '0')
        break;
      long number = Long.parseLong(string.substring(index, i + 1));
      if (index == 0)
        search(result, current + number, string, target, i + 1, number, number);
      else {
        search(result, current + "+" + number, string, target, i + 1, value + number, number);
        search(result, current + "-" + number, string, target, i + 1, value - number, -number);
        search(result, current + "*" + number, string, target, i + 1, value - prev + prev * number,
            prev * number);
      }
    }
  }
}
// @lc code=end

