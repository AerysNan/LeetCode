/*
 * @lc app=leetcode.cn id=976 lang=java
 *
 * [976] 三角形的最大周长
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int largestPerimeter(int[] A) {
    Arrays.sort(A);
    for (int i = A.length - 3; i >= 0; i--) {
      if (A[i] + A[i + 1] > A[i + 2])
        return A[i] + A[i + 1] + A[i + 2];
    }
    return 0;
  }

}
// @lc code=end
