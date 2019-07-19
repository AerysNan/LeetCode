import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找常用字符
 */
class Solution {
  public List<String> commonChars(String[] A) {
    int[] sum = new int[26];
    for (int i = 0; i < 26; i++)
      sum[i] = Integer.MAX_VALUE;
    for (String s : A) {
      int[] freq = new int[26];
      for (int i = 0; i < s.length(); i++)
        freq[s.charAt(i) - 'a']++;
      for (int i = 0; i < 26; i++)
        sum[i] = Math.min(sum[i], freq[i]);
    }
    ArrayList<String> result = new ArrayList<>();
    for (int i = 0; i < 26; i++)
      for (int j = 0; j < sum[i]; j++)
        result.add(String.valueOf((char) (i + 'a')));
    return result;
  }
}
