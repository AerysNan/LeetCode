/*
 * @lc app=leetcode.cn id=985 lang=java
 *
 * [985] 查询后的偶数和
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    int n = queries.length, sum = Arrays.stream(A).filter(x -> x % 2 == 0).sum();
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      int value = queries[i][0], index = queries[i][1];
      if (A[index] % 2 == 0)
        sum -= A[index];
      A[index] += value;
      if (A[index] % 2 == 0)
        sum += A[index];
      result[i] = sum;
    }
    return result;
  }
}
// @lc code=end
