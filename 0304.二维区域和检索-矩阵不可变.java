/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {
  int[][] prefix;

  public NumMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0)
      return;
    int m = matrix.length, n = matrix[0].length;
    prefix = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++)
      for (int j = 1; j <= n; j++)
        prefix[i][j] =
            prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return prefix[row2 + 1][col2 + 1] - prefix[row2 + 1][col1] - prefix[row1][col2 + 1]
        + prefix[row1][col1];
  }
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj = new
 * NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

