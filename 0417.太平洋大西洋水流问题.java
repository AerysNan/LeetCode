/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
  int[][] direction = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    List<List<Integer>> result = new ArrayList<>();
    if (matrix.length == 0 || matrix[0].length == 0)
      return result;
    HashSet<Integer> pacific = new HashSet<>();
    HashSet<Integer> atlantic = new HashSet<>();
    for (int i = 0; i < matrix[0].length; i++) {
      dfs(matrix, 0, i, pacific);
      dfs(matrix, matrix.length - 1, i, atlantic);
    }
    for (int i = 0; i < matrix.length; i++) {
      dfs(matrix, i, 0, pacific);
      dfs(matrix, i, matrix[0].length - 1, atlantic);
    }

    for (int i : pacific)
      if (atlantic.contains(i))
        result.add(decode(i, matrix));
    return result;
  }

  void dfs(int[][] matrix, int i, int j, HashSet<Integer> result) {
    if (!result.add(encode(i, j, matrix)))
      return;
    for (int[] dir : direction) {
      int x = dir[0] + i;
      int y = dir[1] + j;
      if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
          && matrix[x][y] >= matrix[i][j])
        dfs(matrix, x, y, result);
    }
  }

  List<Integer> decode(int i, int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    result.add(i / matrix[0].length);
    result.add(i % matrix[0].length);
    return result;
  }

  int encode(int i, int j, int[][] matrix) {
    return i * matrix[0].length + j;
  }
}
// @lc code=end

