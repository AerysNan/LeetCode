/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */
class Solution {
  public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] result = new int[m + n];
    int[] number1 = new int[m];
    int[] number2 = new int[n];
    for (int i = m - 1; i >= 0; i--)
      number1[m - 1 - i] = num1.charAt(i) - '0';
    for (int i = n - 1; i >= 0; i--)
      number2[n - 1 - i] = num2.charAt(i) - '0';
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        result[i + j] += number1[i] * number2[j];
    for (int i = 0; i < m + n - 1; i++) {
      result[i + 1] += result[i] / 10;
      result[i] %= 10;
    }
    String r = "";
    int index = m + n - 1;
    while (index >= 0 && result[index] == 0)
      index--;
    if (index < 0)
      return "0";
    for (int i = 0; i <= index; i++)
      r = result[i] + r;
    return r;
  }
}
