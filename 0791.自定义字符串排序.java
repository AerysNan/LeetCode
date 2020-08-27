/*
 * @lc app=leetcode.cn id=791 lang=java
 *
 * [791] 自定义字符串排序
 */

// @lc code=start
class Solution {
  public String customSortString(String S, String T) {
    int[] count = new int[26];
    for (char c : T.toCharArray())
      count[c - 'a']++;
    StringBuilder result = new StringBuilder();
    for (char c : S.toCharArray()) {
      for (int i = 0; i < count[c - 'a']; i++)
        result.append(c);
      count[c - 'a'] = 0;
    }
    for (int i = 0; i < 26; i++)
      for (int j = 0; j < count[i]; j++)
        result.append((char) (i + 'a'));
    return result.toString();
  }
}
// @lc code=end
