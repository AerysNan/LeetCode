/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */

// @lc code=start
class Solution {
  public int reversePairs(int[] nums) {
    return mergesort_and_count(nums, 0, nums.length - 1);
  }

  void merge(int[] A, int start, int mid, int end) {
    int[] L = new int[mid - start + 1], R = new int[end - mid];
    System.arraycopy(A, start, L, 0, L.length);
    System.arraycopy(A, mid + 1, R, 0, R.length);
    int i = 0, j = 0;
    for (int k = start; k <= end; k++) {
      if (j >= R.length || (i < L.length && L[i] <= R[j]))
        A[k] = L[i++];
      else
        A[k] = R[j++];
    }
  }

  int mergesort_and_count(int[] A, int start, int end) {
    if (start >= end)
      return 0;
    int mid = (start + end) / 2;
    int count = mergesort_and_count(A, start, mid) + mergesort_and_count(A, mid + 1, end);
    for (int i = start, j = mid + 1; i <= mid; i++) {
      while (j <= end && (long) A[i] > (long) A[j] * 2)
        j++;
      count += j - (mid + 1);
    }
    merge(A, start, mid, end);
    return count;
  }
}
// @lc code=end

