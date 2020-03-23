/*
 * @lc app=leetcode.cn id=1337 lang=java
 *
 * [1337] 方阵中战斗力最弱的 K 行
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  public int[] kWeakestRows(int[][] mat, int k) {
    int n = mat.length, m = mat[0].length;
    int[] indices = new int[n];
    ArrayList<Integer> result = new ArrayList<>();
    while (result.size() < k) {
      for (int i = 0; i < n; i++) {
        if (indices[i] < 0)
          continue;
        if (indices[i] == m || mat[i][indices[i]] == 0) {
          result.add(i);
          if (result.size() == k)
            break;
          indices[i] = -1;
        } else
          indices[i]++;
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}
// @lc code=end

