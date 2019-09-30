/*
 * @lc app=leetcode.cn id=1013 lang=java
 *
 * [1013] 将数组分成和相等的三个部分
 */

// @lc code=start
class Solution {
  public boolean canThreePartsEqualSum(int[] A) {
    int n = A.length;
    if (n < 3)
      return false;
    int[] prefixSum = new int[n + 1];
    for (int i = 1; i <= n; i++)
      prefixSum[i] = prefixSum[i - 1] + A[i - 1];
    int index = 1;
    while (index < n - 1) {
      int l = prefixSum[index], r = prefixSum[n] - prefixSum[index];
      if (l * 2 == r) {
        int _index = index + 1;
        while (_index < n) {
          int _l = prefixSum[_index] - prefixSum[index], _r = prefixSum[n] - prefixSum[_index];
          if (_l == _r)
            return true;
          _index++;
        }
      }
      index++;
    }
    return false;
  }
}
// @lc code=end

