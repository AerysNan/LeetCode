/*
 * @lc app=leetcode.cn id=1081 lang=java
 *
 * [1081] 不同字符的最小子序列
 */
class Solution {
  public String smallestSubsequence(String s) {
    if (s.length() == 0)
      return "";
    char[] array = s.toCharArray();
    int[] count = new int[26];
    int length = array.length;
    for (int i = 0; i < length; i++)
      count[array[i] - 'a']++;
    int minIndex = 0;
    for (int i = 0; i < length; i++) {
      if (array[i] < array[minIndex])
        minIndex = i;
      count[array[i] - 'a']--;
      if (count[array[i] - 'a'] == 0)
        break;
    }
    char c = array[minIndex];
    String subString = s.substring(minIndex + 1).replaceAll(String.valueOf(c), "");
    return c + smallestSubsequence(subString);
  }
}
