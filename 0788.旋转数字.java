import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=788 lang=java
 *
 * [788] 旋转数字
 */

// @lc code=start
class Solution {
  public int rotatedDigits(int N) {
    return (int) IntStream.rangeClosed(1, N).filter(x -> good(x)).count();
  }

  boolean good(int x) {
    String s = String.valueOf(x);
    boolean identical = true;
    for (char c : s.toCharArray()) {
      if (c == '3' || c == '4' || c == '7')
        return false;
      if (c == '2' || c == '5' || c == '6' || c == '9')
        identical = false;
    }
    return !identical;
  }
}
// @lc code=end
