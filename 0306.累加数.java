/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
import java.math.BigInteger;

class Solution {
  public boolean isAdditiveNumber(String num) {
    int n = num.length();
    for (int i = 1; i <= n / 2; i++) {
      if (num.charAt(0) == '0' && i > 1)
        return false;
      BigInteger x = new BigInteger(num.substring(0, i));
      for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
        if (num.charAt(i) == '0' && j > 1)
          break;
        BigInteger y = new BigInteger(num.substring(i, i + j));
        if (isValid(x, y, i + j, num))
          return true;
      }
    }
    return false;
  }

  boolean isValid(BigInteger x, BigInteger y, int index, String num) {
    if (index == num.length())
      return true;
    String value = y.add(x).toString();
    return num.startsWith(value, index) && isValid(y, x.add(y), index + value.length(), num);
  }
}
// @lc code=end

