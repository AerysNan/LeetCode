/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有K个重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * algorithms
 * Medium (33.74%)
 * Total Accepted:    500
 * Total Submissions: 1.5K
 * Testcase Example:  '"aaabb"\n3'
 *
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 *
 *
 * 示例 2:
 *
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 *
 */
class Solution {
  private int length;

  public int longestSubstring(String s, int k) {
    length = 0;
    char[] array = s.toCharArray();
    for (int i = 1; i <= 26; i++) {
      int low = 0, high = 0, lettersOccuredCnt = 0, lettersOccuredAtLeastKTimesCnt = 0;
      int[] count = new int[26];
      while (low < array.length) {
        if (lettersOccuredCnt <= i && high < array.length) {
          int index = array[high] - 'a';
          if (count[index] == 0)
            lettersOccuredCnt++;
          count[index]++;
          if (count[index] == k)
            lettersOccuredAtLeastKTimesCnt++;
          high++;
        } else {
          int index = array[low] - 'a';
          if (count[index] == k)
            lettersOccuredAtLeastKTimesCnt--;
          count[index]--;
          if (count[index] == 0)
            lettersOccuredCnt--;
          low++;
        }
        if (lettersOccuredAtLeastKTimesCnt == i && lettersOccuredCnt == i)
          length = Math.max(length, high - low);
      }
    }
    return length;
  }
}
