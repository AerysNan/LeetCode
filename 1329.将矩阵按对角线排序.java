/*
 * @lc app=leetcode.cn id=1329 lang=java
 *
 * [1329] 将矩阵按对角线排序
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
  public int[][] diagonalSort(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    LinkedList<LinkedList<Integer>> map = new LinkedList<>();
    for (int i = 0; i < m + n; i++)
      map.add(new LinkedList<>());
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        map.get(i - j + n - 1).addLast(mat[i][j]);
    map.forEach(l -> l.sort(Comparator.<Integer>naturalOrder()));
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        mat[i][j] = map.get(i - j + n - 1).pollFirst();
    return mat;
  }
}
// @lc code=end

