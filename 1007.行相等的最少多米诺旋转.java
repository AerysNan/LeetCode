/*
 * @lc app=leetcode.cn id=1007 lang=java
 *
 * [1007] 行相等的最少多米诺旋转
 */
class Solution {
  public int minDominoRotations(int[] A, int[] B) {
    int n = A.length;
    int same = findSame(A, B);
    if (same > 0) {
      int cnt1 = 0, cnt2 = 0;
      for (int i = 0; i < n; i++) {
        if (A[i] == same && B[i] != same)
          cnt1++;
        else if (B[i] == same && A[i] != same)
          cnt2++;
        else if (A[i] != same && B[i] != same)
          return -1;
      }
      return Math.min(cnt1, cnt2);
    } else {
      int[] cnt = new int[6];
      for (int i = 0; i < n; i++) {
        cnt[A[i] - 1]++;
        cnt[B[i] - 1]++;
      }
      for (int i = 0; i < 6; i++) {
        if (cnt[i] != n)
          continue;
        int target = i + 1, cnt1 = 0, cnt2 = 0;
        for (int j = 0; j < n; j++) {
          if (A[j] == target)
            cnt1++;
          if (B[j] == target)
            cnt2++;
        }
        return Math.min(cnt1, cnt2);
      }
      return -1;
    }
  }

  int findSame(int[] A, int[] B) {
    int n = A.length;
    for (int i = 0; i < n; i++)
      if (A[i] == B[i])
        return A[i];
    return -1;
  }
}
