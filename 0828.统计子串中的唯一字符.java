/*
 * @lc app=leetcode.cn id=828 lang=java
 *
 * [828] 统计子串中的唯一字符
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
  public int uniqueLetterString(String S) {
    HashMap<Character, ArrayList<Integer>> index = new HashMap<>();
    int n = S.length();
    for (int i = 0; i < n; i++) {
      char c = S.charAt(i);
      index.computeIfAbsent(c, x -> new ArrayList<Integer>()).add(i);
    }
    long result = 0;
    for (ArrayList<Integer> A : index.values()) {
      for (int i = 0; i < A.size(); i++) {
        long prev = i > 0 ? A.get(i - 1) : -1;
        long next = i < A.size() - 1 ? A.get(i + 1) : n;
        result += (A.get(i) - prev) * (next - A.get(i));
      }
    }
    return (int) result % (int) (1e9 + 7);
  }
}
// @lc code=end
