/*
 * @lc app=leetcode.cn id=363 lang=java
 *
 * [363] 矩形区域不超过 K 的最大数值和
 */

// @lc code=start
import java.util.TreeSet;

class Solution {
  public int maxSumSubmatrix(int[][] matrix, int k) {
    if (matrix.length == 0 || matrix[0].length == 0)
      return 0;
    int m = matrix.length, n = matrix[0].length, result = Integer.MIN_VALUE;
    for (int l = 0; l < n; l++) {
      int[] sums = new int[m];
      for (int r = l; r < n; r++) {
        for (int i = 0; i < m; i++)
          sums[i] += matrix[i][r];
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(0);
        int acc = 0;
        for (int sum : sums) {
          acc += sum;
          Integer num = set.ceiling(acc - k);
          if (num != null)
            result = Math.max(result, acc - num);
          set.add(acc);
        }
      }
    }
    return result;
  }
}
// @lc code=end

