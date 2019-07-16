/*
 * @lc app=leetcode.cn id=1031 lang=java
 *
 * [1031] 两个非重叠子数组的最大和
 */
class Solution {
  public int maxSumTwoNoOverlap(int[] A, int L, int M) {
    int[] sumL = new int[A.length - L + 1];
    int sum = 0;
    for (int i = 0; i < L; i++)
      sum += A[i];
    sumL[0] = sum;
    for (int i = 1; i <= A.length - L; i++)
      sumL[i] = sumL[i - 1] - A[i - 1] + A[i + L - 1];
    int[] sumM = new int[A.length - M + 1];
    sum = 0;
    for (int i = 0; i < M; i++)
      sum += A[i];
    sumM[0] = sum;
    for (int i = 1; i <= A.length - M; i++)
      sumM[i] = sumM[i - 1] - A[i - 1] + A[i + M - 1];
    int result = -1;
    for (int i = 0; i < sumL.length; i++) {
      for (int j = 0; j < sumM.length; j++) {
        if (!(i + L <= j || j + M <= i))
          continue;
        result = Math.max(result, sumL[i] + sumM[j]);
      }
    }
    return result;
  }
}
