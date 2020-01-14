/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start

class Solution {
  public int firstUniqChar(String s) {
    int[] map = new int[26], index = new int[26];
    for (int i = 0; i < s.length(); i++) {
      int value = s.charAt(i) - 'a';
      map[value]++;
      index[value] = i;
    }
    for (int i = 0; i < s.length(); i++) {
      int value = s.charAt(i) - 'a';
      if (map[value] == 1)
        return index[value];
    }
    return -1;
  }
}
// @lc code=end

