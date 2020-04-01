/*
 * @lc app=leetcode.cn id=1170 lang=java
 *
 * [1170] 比较字符串最小字母出现频次
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int[] numSmallerByFrequency(String[] queries, String[] words) {
    int[] f_queries = Arrays.stream(queries).mapToInt(s -> f(s)).toArray();
    int[] f_words = Arrays.stream(words).mapToInt(s -> f(s)).toArray();
    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++)
      for (int j = 0; j < words.length; j++)
        if (f_queries[i] < f_words[j])
          result[i]++;
    return result;
  }

  int f(String s) {
    int index = Integer.MAX_VALUE;
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
      index = Math.min(index, c - 'a');
    }
    return count[index];
  }
}
// @lc code=end

