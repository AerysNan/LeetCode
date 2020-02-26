/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
import java.util.HashMap;

class Solution {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int result = 0;
    for (int i = 0; i < A.length; i++)
      for (int j = 0; j < B.length; j++)
        map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);

    for (int i = 0; i < C.length; i++)
      for (int j = 0; j < D.length; j++)
        result += map.getOrDefault(-C[i] - D[j], 0);
    return result;
  }
}
// @lc code=end

