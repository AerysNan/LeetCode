/*
 * @lc app=leetcode.cn id=1073 lang=java
 *
 * [1073] 负二进制数相加
 */
class Solution {
  public int[] addNegabinary(int[] arr1, int[] arr2) {
    int N = arr1.length > arr2.length ? arr1.length : arr2.length;
    int[] num1 = new int[N + 1];
    int[] num2 = new int[N + 1];
    int[] result = new int[N + 2];
    for (int i = arr1.length - 1, j = 0; i >= 0; i--, j++)
      num1[j] = arr1[i];
    for (int i = arr2.length - 1, j = 0; i >= 0; i--, j++)
      num2[j] = arr2[i];
    for (int i = 0; i <= N; i++) {
      result[i] += num1[i] + num2[i];
      if (result[i] >= 2) {
        result[i] -= 2;
        result[i + 1] -= 1;
      } else if (result[i] == -1) {
        result[i] = 1;
        result[i + 1] += 1;
      }
    }
    int index = N + 1;
    while (index >= 0 && result[index] == 0)
      index--;
    if (index < 0)
      return new int[] { 0 };
    int[] sum = new int[index + 1];
    for (int i = index; i >= 0; i--)
      sum[index - i] = result[i];
    return sum;
  }
}
