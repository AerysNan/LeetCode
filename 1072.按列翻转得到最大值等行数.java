import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1072 lang=java
 *
 * [1072] 按列翻转得到最大值等行数
 */
class Solution {
  public int maxEqualRowsAfterFlips(int[][] matrix) {
    HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
    for (int[] row : matrix) {
      if (row[0] == 0)
        for (int i = 0; i < row.length; i++)
          row[i] = 1 - row[i];
      ArrayList<Integer> list = new ArrayList<>();
      for (int value : row)
        list.add(value);
      if (map.containsKey(list))
        map.put(list, map.get(list) + 1);
      else
        map.put(list, 1);
    }
    int result = 0;
    for (int value : map.values())
      result = Math.max(result, value);
    return result;
  }
}
