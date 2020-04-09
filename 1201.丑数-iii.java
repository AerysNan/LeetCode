/*
 * @lc app=leetcode.cn id=1201 lang=java
 *
 * [1201] 丑数 III
 */

// @lc code=start
class Solution {
  long mcm_a_b, mcm_a_c, mcm_b_c, mcm_a_b_c;

  int nthUglyNumber(int n, int a, int b, int c) {
    mcm_a_b = mcm(a, b);
    mcm_a_c = mcm(a, c);
    mcm_b_c = mcm(b, c);
    mcm_a_b_c = mcm(mcm_a_b, c);
    long low = Math.min(Math.min(a, b), c);
    long high = low * n;
    long result = search(low, high, a, b, c, n);
    return (int) (result - Math.min(result % a, Math.min(result % b, result % c)));
  }

  long search(long low, long high, int a, int b, int c, long n) {
    if (low >= high)
      return low;
    long mid = (low + high) >> 1;


    long count = mid / a + mid / b + mid / c - mid / mcm_a_b - mid / mcm_b_c - mid / mcm_a_c
        + mid / mcm_a_b_c;
    if (count == n)
      return mid;
    if (count < n)
      return search(mid + 1, high, a, b, c, n);
    return search(low, mid - 1, a, b, c, n);
  }

  long mcm(long a, long b) {
    long mul = a * b;
    while (b > 0) {
      long tmp = a % b;
      a = b;
      b = tmp;
    }
    return mul / a;
  }
}
// @lc code=end

