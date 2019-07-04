import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1048 lang=java
 *
 * [1048] 最长字符串链
 */
class Solution {
  boolean isPrev(String s, String t) {
    if (s.length() + 1 != t.length())
      return false;
    boolean hit = false;
    int i = 0, j = 0;
    while (i < s.length()) {
      if (s.charAt(i) != t.charAt(j)) {
        if (!hit) {
          hit = true;
          j++;
        } else
          return false;
      } else {
        i++;
        j++;
      }
    }
    return true;
  }

  public int longestStrChain(String[] words) {
    Arrays.sort(words, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        int result = s1.length() - s2.length();
        return result == 0 ? s1.compareTo(s2) : result;
      }
    });
    int n = words.length;
    int[] dp = new int[n];
    for (int i = 0; i < n; i++)
      dp[i] = 1;
    for (int i = 1; i < n; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (words[j].length() + 1 < words[i].length())
          break;
        if (isPrev(words[j], words[i]))
          dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }
    int result = -1;
    for (int value : dp)
      result = Math.max(result, value);
    return result;
  }
}
