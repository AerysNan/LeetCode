/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  public String addBinary(String a, String b) {
    int m = a.length(), n = b.length();
    int length = Math.max(m, n);
    int[] la = new int[length], lb = new int[length], result = new int[length];
    for (int i = 0; i < a.length(); i++)
      la[length - 1 - i] = a.charAt(m - 1 - i) - '0';
    for (int i = 0; i < b.length(); i++)
      lb[length - 1 - i] = b.charAt(n - 1 - i) - '0';
    int c = 0;
    for (int i = length - 1; i >= 0; i--) {
      result[i] = c + la[i] + lb[i];
      System.out.println(result[i]);
      c = result[i] >= 2 ? 1 : 0;
      result[i] %= 2;
    }
    StringBuilder sb = new StringBuilder();
    if (c != 0)
      sb.append('1');
    for (int i = 0; i < length; i++)
      sb.append(result[i]);
    return sb.toString();
  }
}
// @lc code=end
