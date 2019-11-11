/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 */

// @lc code=start
import java.util.HashMap;

class Solution {
  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0)
      return "0";
    StringBuilder result = new StringBuilder();
    result.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
    long num = Math.abs((long) numerator);
    long den = Math.abs((long) denominator);
    result.append(num / den);
    num %= den;
    if (num == 0)
      return result.toString();
    result.append(".");
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    while (num != 0) {
      map.put(num, result.length());
      num *= 10;
      result.append(num / den);
      num %= den;
      if (map.containsKey(num)) {
        result.insert(map.get(num), "(");
        result.append(')');
        break;
      }
    }
    return result.toString();
  }
}
// @lc code=end

