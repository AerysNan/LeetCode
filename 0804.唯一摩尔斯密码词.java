/*
 * @lc app=leetcode.cn id=804 lang=java
 *
 * [804] 唯一摩尔斯密码词
 */

// @lc code=start
import java.util.HashSet;

class Solution {
  public int uniqueMorseRepresentations(String[] words) {
    String[] dictionary = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
        ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
    HashSet<String> set = new HashSet<>();
    for (String word : words) {
      StringBuilder builder = new StringBuilder();
      for (char c : word.toCharArray())
        builder.append(dictionary[c - 'a']);
      set.add(builder.toString());
    }
    return set.size();
  }
}
// @lc code=end
