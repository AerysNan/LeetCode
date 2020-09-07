/*
 * @lc app=leetcode.cn id=824 lang=java
 *
 * [824] 山羊拉丁文
 */

// @lc code=start
import java.util.HashSet;

class Solution {
  public String toGoatLatin(String S) {
    char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };
    HashSet<Character> set = new HashSet<>();
    for (char vowel : vowels) {
      set.add(vowel);
      set.add(Character.toUpperCase(vowel));
    }
    String[] words = S.split(" ");
    StringBuilder result = new StringBuilder();
    int index = 1;
    for (String word : words) {
      result.append(' ');
      if (!set.contains(word.charAt(0)))
        result.append(word.substring(1)).append(word.charAt(0));
      else
        result.append(word);
      result.append("ma");
      for (int i = 0; i < index; i++)
        result.append('a');
      index++;
    }
    return result.substring(1);
  }
}
// @lc code=end
