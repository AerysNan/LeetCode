/*
 * @lc app=leetcode.cn id=823 lang=java
 *
 * [823] 带因子的二叉树
 */

// @lc code=start
import java.util.Arrays;
import java.util.HashMap;

class Solution {
  public int numFactoredBinaryTrees(int[] A) {
    int M = (int) 1e9 + 7;
    int n = A.length;
    Arrays.sort(A);
    long[] dp = new long[n];
    Arrays.fill(dp, 1);
    HashMap<Integer, Integer> index = new HashMap<>();
    for (int i = 0; i < n; i++)
      index.put(A[i], i);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (A[i] % A[j] == 0) {
          int right = A[i] / A[j];
          if (index.containsKey(right)) {
            dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % M;
          }
        }
      }
    }
    return (int) (Arrays.stream(dp).sum() % M);
  }
}
// @lc code=end
