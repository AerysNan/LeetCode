/*
 * @lc app=leetcode.cn id=1053 lang=java
 *
 * [1053] 交换一次的先前排列
 */
class Solution {
  public int[] prevPermOpt1(int[] A) {
    int n = A.length;
    int index1 = -1, index2 = -1;
    for (int i = n - 2; i >= 0; i--) {
      if (A[i + 1] >= A[i])
        continue;
      index1 = i;
      break;
    }
    if (index1 < 0)
      return A;
    for (int i = n - 1; i > index1; i--) {
      if (A[i] >= A[index1])
        continue;
      index2 = i;
      break;
    }
    while (index2 > 0 && A[index2] == A[index2 - 1])
      index2--;
    int tmp = A[index2];
    A[index2] = A[index1];
    A[index1] = tmp;
    return A;
  }
}
