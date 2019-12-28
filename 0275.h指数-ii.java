/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H指数 II
 */

// @lc code=start
class Solution {
  public int hIndex(int[] citations) {
    if (citations.length == 0)
      return 0;
    int n = citations.length, l = 0, r = n - 1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (citations[mid] >= n - mid)
        r = mid;
      else
        l = mid + 1;
    }
    return citations[l] >= n - l ? n - l : 0;
  }
}
// @lc code=end

