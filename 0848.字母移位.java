/*
 * @lc app=leetcode.cn id=848 lang=java
 *
 * [848] 字母移位
 */

// @lc code=start
class Solution {
  public String shiftingLetters(String S, int[] shifts) {
    char[] array = S.toCharArray();
    shifts[shifts.length - 1] %= 26;
    for (int i = shifts.length - 1; i > 0; i--)
      shifts[i - 1] = (shifts[i - 1] + shifts[i]) % 26;
    for (int i = 0; i < array.length; i++) {
      array[i] += shifts[i];
      if (array[i] > 'z')
        array[i] -= 26;
    }
    return new String(array);
  }
}
// @lc code=end
