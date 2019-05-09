/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */
class Solution {
  public String removeDuplicateLetters(String s) {
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
    return c + removeDuplicateLetters(subString);
  }
}
