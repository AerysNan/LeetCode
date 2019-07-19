/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */
class Solution {
  public int longestOnes(int[] A, int K) {
    int result = -1, begin = -1, end = 0, n = A.length, count = 0;
    while (end < n) {
      count += A[end] == 0 ? 1 : 0;
      while (count > K) {
        begin++;
        count -= A[begin] == 0 ? 1 : 0;
      }
      result = Math.max(result, end++ - begin);
    }
    return result;
  }
}
