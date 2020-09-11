/*
 * @lc app=leetcode.cn id=833 lang=java
 *
 * [833] 字符串中的查找与替换
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    int n = S.length();
    int[] match = new int[n];
    Arrays.fill(match, -1);
    for (int i = 0; i < indexes.length; i++) {
      int index = indexes[i];
      if (S.substring(index, index + sources[i].length()).equals(sources[i]))
        match[index] = i;
    }
    StringBuilder result = new StringBuilder();
    int i = 0;
    while (i < n) {
      if (match[i] >= 0) {
        result.append(targets[match[i]]);
        i += sources[match[i]].length();
      } else
        result.append(S.charAt(i++));
    }
    return result.toString();
  }
}

// @lc code=end
