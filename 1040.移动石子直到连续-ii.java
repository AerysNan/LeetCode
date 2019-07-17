/*
 * @lc app=leetcode.cn id=1040 lang=java
 *
 * [1040] 移动石子直到连续 II
 */
class Solution {
  public int[] numMovesStonesII(int[] A) {
    Arrays.sort(A);
    int i = 0, n = A.length, low = n;
    int high = Math.max(A[n - 1] - n + 2 - A[1], A[n - 2] - A[0] - n + 2);
    for (int j = 0; j < n; j++) {
      while (A[j] - A[i] >= n)
        i++;
      low = Math.min(low, (j - i + 1 == n - 1 && A[j] - A[i] == n - 2) ? 2 : (n - (j - i + 1)));
    }
    return new int[] { low, high };
  }
}
