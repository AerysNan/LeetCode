/*
 * @lc app=leetcode.cn id=966 lang=java
 *
 * [966] 元音拼写检查器
 */

// @lc code=start
import java.util.HashSet;
import java.util.HashMap;

class Solution {
  HashSet<String> perfect;
  HashMap<String, String> capital;
  HashMap<String, String> vowel;

  public String[] spellchecker(String[] wordlist, String[] queries) {
    perfect = new HashSet<>();
    capital = new HashMap<>();
    vowel = new HashMap<>();
    for (String word : wordlist) {
      perfect.add(word);
      String lower = word.toLowerCase();
      capital.putIfAbsent(lower, word);
      String devowel = devowel(lower);
      vowel.putIfAbsent(devowel, word);
    }
    String[] result = new String[queries.length];
    int t = 0;
    for (String query : queries)
      result[t++] = solve(query);
    return result;
  }

  public String solve(String query) {
    if (perfect.contains(query))
      return query;
    String lower = query.toLowerCase();
    if (capital.containsKey(lower))
      return capital.get(lower);
    String devowel = devowel(lower);
    if (vowel.containsKey(devowel))
      return vowel.get(devowel);
    return "";
  }

  public String devowel(String word) {
    StringBuilder result = new StringBuilder();
    for (char c : word.toCharArray())
      result.append(isVowel(c) ? '*' : c);
    return result.toString();
  }

  public boolean isVowel(char c) {
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
  }
}
// @lc code=end
