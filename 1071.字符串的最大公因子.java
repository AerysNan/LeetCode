/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 */
class Solution {
  public String gcdOfStrings(String str1, String str2) {
    if (str1 == "" || str2 == "")
      return "";
    if (str1.equals(str2))
      return str1;
    if (str1.length() < str2.length())
      return gcdOfStrings(str2, str1);
    if (!str1.startsWith(str2))
      return "";
    return gcdOfStrings(str2, str1.substring(str2.length()));
  }
}
