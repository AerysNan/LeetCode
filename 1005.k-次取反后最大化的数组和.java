import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */
class Solution {
  public int largestSumAfterKNegations(int[] A, int K) {
    int negCount = 0, absMin = Integer.MAX_VALUE;
    for (int i : A) {
      if (i < 0)
        negCount++;
      if (absMin > Math.abs(i))
        absMin = Math.abs(i);
    }
    Arrays.sort(A);
    if (negCount >= K) {
      for (int i = 0; i < K; i++)
        A[i] = -A[i];
      return sum(A);
    }
    for (int i = 0; i < negCount; i++)
      A[i] = -A[i];
    if ((K - negCount) % 2 == 0)
      return sum(A);
    return sum(A) - 2 * absMin;
  }

  int sum(int[] A) {
    int result = 0;
    for (int i : A)
      result += i;
    return result;
  }
}
