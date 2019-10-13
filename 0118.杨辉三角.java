/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows == 0)
      return result;
    ArrayList<Integer> line = new ArrayList<>();
    line.add(1);
    result.add(line);
    for (int i = 2; i <= numRows; i++) {
      ArrayList<Integer> output = new ArrayList<>();
      output.add(1);
      List<Integer> prev = result.get(result.size() - 1);
      for (int k = 2; k < i; k++)
        output.add(prev.get(k - 2) + prev.get(k - 1));
      output.add(1);
      result.add(output);
    }
    return result;
  }
}
// @lc code=end

