/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> getRow(int rowIndex) {
    Integer[] result = new Integer[rowIndex + 1];
    result[0] = 1;
    for (int i = 1; i <= rowIndex; i++) {
      int stash = 1;
      for (int j = 1; j < i; j++) {
        int tmp = stash;
        stash = result[j] + result[j - 1];
        result[j - 1] = tmp;
      }
      result[i - 1] = stash;
      result[i] = 1;
    }
    return Arrays.asList(result);
  }
}
// @lc code=end

