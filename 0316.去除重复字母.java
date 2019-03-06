/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 *
 * https://leetcode-cn.com/problems/remove-duplicate-letters/description/
 *
 * algorithms
 * Hard (26.73%)
 * Total Accepted:    671
 * Total Submissions: 2.5K
 * Testcase Example:  '"bcabc"'
 *
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1:
 *
 * 输入: "bcabc"
 * 输出: "abc"
 *
 *
 * 示例 2:
 *
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 *
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
