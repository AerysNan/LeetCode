/*
 * @lc app=leetcode.cn id=600 lang=java
 *
 * [600] 不含连续1的非负整数
 */
class Solution {
  public int findIntegers(int num) {
    String string = String.valueOf(Integer.toBinaryString(num));
    int n = string.length();
    int[] headOne = new int[n];
    int[] headZero = new int[n];
    headOne[0] = 1;
    headZero[0] = 1;
    for (int i = 1; i < n; i++) {
      headZero[i] = headOne[i - 1] + headZero[i - 1];
      headOne[i] = headZero[i - 1];
    }
    int result = headOne[n - 1] + headZero[n - 1];
    System.out.println(result);
    for (int i = 1; i < n; i++) {
      if (string.charAt(i) == '1' && string.charAt(i - 1) == '1')
        break;
      if (string.charAt(i) == '0' && string.charAt(i - 1) == '0')
        result -= headOne[n - i - 1];
    }
    return result;
  }
}
