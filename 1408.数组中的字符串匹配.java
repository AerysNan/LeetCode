/*
 * @lc app=leetcode.cn id=1408 lang=java
 *
 * [1408] 数组中的字符串匹配
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

class Solution {
  public List<String> stringMatching(String[] words) {
    HashSet<String> result = new HashSet<>();
    int n = words.length;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (i != j && words[j].contains(words[i]))
          result.add(words[i]);
    return result.stream().collect(Collectors.toList());
  }
}
// @lc code=end

