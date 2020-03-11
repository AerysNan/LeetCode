import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=765 lang=java
 *
 * [765] 情侣牵手
 */

// @lc code=start
class Solution {
  public int minSwapsCouples(int[] row) {
    int n = row.length, result = 0;
    int[] position = new int[n];
    for (int i = 0; i < n; i++)
      position[row[i]] = i;
    for (int i = 0; i < n; i += 2) {
      int x = row[i];
      if (row[i + 1] == (x ^ 1))
        continue;
      result++;
      int pos = position[x ^ 1];
      position[row[i + 1]] = position[x ^ 1];
      position[x ^ 1] = i + 1;
      row[pos] = row[i + 1];
      row[i + 1] = x ^ 1;
    }
    return result;
  }
}
// @lc code=end

