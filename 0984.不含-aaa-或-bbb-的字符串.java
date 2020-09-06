/*
 * @lc app=leetcode.cn id=984 lang=java
 *
 * [984] 不含 AAA 或 BBB 的字符串
 */

// @lc code=start
class Solution {
  public String strWithout3a3b(int A, int B) {
    char[] array = new char[A + B];
    int n = 0;
    while (A > 0 || B > 0) {
      boolean nextA = false;
      nextA = n >= 2 && array[n - 1] == array[n - 2] ? array[n - 1] == 'b' : A >= B;
      if (nextA) {
        A--;
        array[n++] = 'a';
      } else {
        B--;
        array[n++] = 'b';
      }
    }
    return new String(array);
  }
}
// @lc code=end
