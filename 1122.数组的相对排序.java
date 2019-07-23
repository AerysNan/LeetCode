/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */
class Solution {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length];
    int max = 0, index = 0;
    for (int i : arr1)
      max = Math.max(max, i);
    int[] count = new int[max + 1];
    for (int i : arr1)
      count[i]++;
    for (int i : arr2) {
      for (int j = 0; j < count[i]; j++)
        result[index++] = i;
      count[i] = 0;
    }
    for (int i = 0; i < count.length; i++)
      for (int j = 0; j < count[i]; j++)
        result[index++] = i;
    return result;
  }
}
