/*
 * @lc app=leetcode.cn id=1178 lang=java
 *
 * [1178] 猜字谜
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    ArrayList<Integer> result = new ArrayList<>();
    HashMap<Integer, Integer> count = new HashMap<>();
    for (String word : words) {
      int bits = 0;
      for (char c : word.toCharArray())
        bits |= (1 << (c - 'a'));
      count.put(bits, count.getOrDefault(bits, 0) + 1);
    }
    for (String puzzle : puzzles) {
      int match = 0, bits = 0;
      for (char c : puzzle.toCharArray())
        bits |= (1 << (c - 'a'));
      for (int i = bits; i > 0; i = (i - 1) & bits)
        if (((1 << (puzzle.charAt(0) - 'a')) & i) > 0)
          match += count.getOrDefault(i, 0);
      result.add(match);
    }
    return result;
  }
}
// @lc code=end

