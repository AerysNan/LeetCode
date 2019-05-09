/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] result = new int[m + n];
    int index1 = 0, index2 = 0, index = 0;
    while (index < m + n) {
      if (index1 == m)
        result[index++] = nums2[index2++];
      else if (index2 == n)
        result[index++] = nums1[index1++];
      else if (nums1[index1] > nums2[index2])
        result[index++] = nums2[index2++];
      else if (nums1[index1] <= nums2[index2])
        result[index++] = nums1[index1++];
    }
    for (int i = 0; i < m + n; i++)
      nums1[i] = result[i];
  }
}
