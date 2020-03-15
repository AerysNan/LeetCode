/*
 * @lc app=leetcode.cn id=930 lang=java
 *
 * [930] 和相同的二元子数组
 */

// @lc code=start
class Solution {
  public int numSubarraysWithSum(int[] A, int S) {
    int il = 0, ir = 0, sl = 0, sr = 0, result = 0;
    for (int j = 0; j < A.length; ++j) {
      sl += A[j];
      while (il < j && sl > S)
        sl -= A[il++];
      sr += A[j];
      while (ir < j && (sr > S || sr == S && A[ir] == 0))
        sr -= A[ir++];
      if (sl == S)
        result += ir - il + 1;
    }
    return result;
  }
}
// @lc code=end

