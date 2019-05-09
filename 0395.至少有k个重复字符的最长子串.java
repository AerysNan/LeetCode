/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有K个重复字符的最长子串
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
