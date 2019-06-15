/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */
class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1)
      return s;
    String[] ss = new String[numRows];
    for (int i = 0; i < numRows; i++)
      ss[i] = "";
    int index = 0;
    boolean down = true;
    for (int i = 0; i < s.length(); i++) {
      ss[index] += s.charAt(i);
      if (down) {
        index++;
        if (index == numRows - 1)
          down = false;
      } else {
        index--;
        if (index == 0)
          down = true;
      }
    }
    String result = "";
    for (String tmp : ss)
      result += tmp;
    return result;
  }
}
