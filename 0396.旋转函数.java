import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=396 lang=java
 *
 * [396] 旋转函数
 */

// @lc code=start
class Solution {
  public int maxRotateFunction(int[] A) {
    int n = A.length;
    long sum = Arrays.stream(A).reduce(0, (x, y) -> x + y);
    long[] prefix = new long[n];
    for (int i = 1; i < n; i++) {
      long delta = sum - n * A[n - i];
      prefix[i] = delta + prefix[i - 1];
    }
    long result = 0;
    for (int i = 0; i < n; i++)
      result += i * A[i];
    return (int) (Arrays.stream(prefix).reduce(0, Math::max) + result);
  }
}
// @lc code=end

