/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */
class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    if (m > n)
      return findMedianSortedArrays(nums2, nums1);
    int lo = 0, hi = m;
    while (lo <= hi) {
      int midM = (lo + hi) / 2;
      int midN = (m + n + 1) / 2 - midM;
      if (midM < m && midN > 0 && nums1[midM] < nums2[midN - 1])
        lo = midM + 1;
      else if (midM > 0 && midN < n && nums1[midM - 1] > nums2[midN])
        hi = midM - 1;
      else {
        int left, right;
        if (midM == 0)
          left = nums2[midN - 1];
        else if (midN == 0)
          left = nums1[midM - 1];
        else
          left = Math.max(nums1[midM - 1], nums2[midN - 1]);
        if ((m + n) % 2 == 1)
          return left;
        if (midM == m)
          right = nums2[midN];
        else if (midN == n)
          right = nums1[midM];
        else
          right = Math.min(nums1[midM], nums2[midN]);
        return (left + right) / 2.0;
      }
    }
    return -1;
  }
}
