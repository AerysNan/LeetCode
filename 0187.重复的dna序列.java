/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    HashSet<String> set = new HashSet<>(), repeated = new HashSet<>();
    for (int i = 0; i + 9 < s.length(); i++) {
      String str = s.substring(i, i + 10);
      if (!set.add(str))
        repeated.add(str);
    }
    return new ArrayList<>(repeated);
  }
}
// @lc code=end

