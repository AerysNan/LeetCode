/*
 * @lc app=leetcode.cn id=1310 lang=java
 *
 * [1310] 子数组异或查询
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int[] xorQueries(int[] arr, int[][] queries) {
    int n = arr.length;
    int[] prefix = new int[n + 1];
    for (int i = 1; i <= n; i++)
      prefix[i] = prefix[i - 1] ^ arr[i - 1];
    return Arrays.stream(queries).mapToInt(x -> prefix[x[0]] ^ prefix[x[1] + 1]).toArray();
  }
}
// @lc code=end

