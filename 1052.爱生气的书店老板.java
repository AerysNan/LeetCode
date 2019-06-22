/*
 * @lc app=leetcode.cn id=1052 lang=java
 *
 * [1052] 爱生气的书店老板
 */
class Solution {
  public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    int n = customers.length;
    int[] value = new int[n + 1];
    for (int i = 1; i <= n; i++)
      value[i] = value[i - 1] + customers[i - 1] * grumpy[i - 1];
    int index = 0, count = -1;
    for (int i = 0; i <= n - X; i++) {
      int sum = value[i + X] - value[i];
      if (sum > count) {
        count = sum;
        index = i;
      }
    }
    for (int i = index; i < index + X; i++)
      grumpy[i] = 0;
    int result = 0;
    for (int i = 0; i < n; i++)
      result += customers[i] * (1 - grumpy[i]);
    return result;
  }
}
