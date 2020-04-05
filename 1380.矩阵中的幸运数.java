/*
 * @lc app=leetcode.cn id=5356 lang=java
 *
 * [5356] 矩阵中的幸运数
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> luckyNumbers(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[] colMax = new int[n], rowMin = new int[m];
    Arrays.fill(colMax, Integer.MIN_VALUE);
    Arrays.fill(rowMin, Integer.MAX_VALUE);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        colMax[j] = Math.max(colMax[j], matrix[i][j]);
        rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
      }
    }
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (matrix[i][j] == colMax[j] && matrix[i][j] == rowMin[i])
          result.add(matrix[i][j]);
    return result;
  }
}
// @lc code=end

