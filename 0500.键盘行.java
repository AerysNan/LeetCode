/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  public String[] findWords(String[] words) {
    int[] pos =
        new int[] {1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};
    ArrayList<String> result = new ArrayList<>();
    for (String word : words) {
      int line = -1;
      boolean valid = true;
      for (char c : word.toLowerCase().toCharArray()) {
        System.out.println(pos[c - 'a']);
        if (line < 0)
          line = pos[c - 'a'];
        else if (line != pos[c - 'a']) {
          valid = false;
          break;
        }
      }
      if (valid)
        result.add(word);
    }
    return result.toArray(new String[result.size()]);
  }
}
// @lc code=end

