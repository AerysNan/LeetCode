/*
 * @lc app=leetcode.cn id=1131 lang=java
 *
 * [1131] 绝对值表达式的最大值
 */
class Solution {
  int[][] args = new int[][] { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

  public int maxAbsValExpr(int[] arr1, int[] arr2) {
    int result = 0, n = arr1.length;
    for (int i = 0; i < 4; i++) {
      int rightVal = args[i][0] * arr1[0] + args[i][1] * arr2[0];
      for (int j = 0; j < n; j++) {
        int leftVal = args[i][0] * arr1[j] + args[i][1] * arr2[j] + j;
        result = Math.max(result, leftVal - rightVal);
        rightVal = Math.min(rightVal, leftVal);
      }
    }
    return result;
  }
}
