/*
 * @lc app=leetcode.cn id=771 lang=java
 *
 * [771] 宝石与石头
 */

// @lc code=start
import java.util.HashSet;

class Solution {
  public int numJewelsInStones(String J, String S) {
    HashSet<Character> set = new HashSet<>();
    for (char c : J.toCharArray())
      set.add(c);
    int result = 0;
    for (char c : S.toCharArray())
      if (set.contains(c))
        result++;
    return result;
  }
}
// @lc code=end

