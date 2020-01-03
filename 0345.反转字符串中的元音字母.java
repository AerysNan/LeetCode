/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
import java.util.Arrays;
import java.util.HashSet;

class Solution {
  public String reverseVowels(String s) {
    if (s.length() <= 0)
      return s;
    HashSet<Character> set = new HashSet<Character>() {
      {
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
      }
    };
    int n = s.length(), l = 0, r = n - 1;
    char[] result = new char[n];
    while (l <= r) {
      while (l <= r && !set.contains(s.charAt(l)))
        result[l] = s.charAt(l++);
      while (l <= r && !set.contains(s.charAt(r)))
        result[r] = s.charAt(r--);
      if (l > r)
        break;
      result[l] = s.charAt(r);
      result[r] = s.charAt(l);
      r--;
      l++;
    }
    return new String(result);
  }
}
// @lc code=end

