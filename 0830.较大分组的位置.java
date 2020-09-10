/*
 * @lc app=leetcode.cn id=830 lang=java
 *
 * [830] 较大分组的位置
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> largeGroupPositions(String S) {
    S += '#';
    ArrayList<List<Integer>> result = new ArrayList<>();
    char[] array = S.toCharArray();
    char prev = 0;
    int n = array.length, count = 0, begin = -1;
    for (int i = 0; i < n; i++) {
      if (prev == array[i])
        count++;
      else {
        prev = array[i];
        if (count >= 3)
          result.add(Arrays.asList(begin, i - 1));
        begin = i;
        count = 1;
      }
    }
    return result;
  }
}
// @lc code=end
