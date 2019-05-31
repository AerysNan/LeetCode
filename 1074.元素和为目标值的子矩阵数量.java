import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1074 lang=java
 *
 * [1074] 元素和为目标值的子矩阵数量
 */
class Solution {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    for (int i = 0; i < m; i++)
      for (int j = 1; j < n; j++)
        matrix[i][j] += matrix[i][j - 1];
    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 1);
        int cur = 0;
        for (int k = 0; k < m; k++) {
          cur += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
          result += counter.getOrDefault(cur - target, 0);
          counter.put(cur, counter.getOrDefault(cur, 0) + 1);
        }
      }
    }
    return result;
  }
}
