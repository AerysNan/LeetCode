/*
 * @lc app=leetcode.cn id=793 lang=java
 *
 * [793] 阶乘函数后K个零
 */

// @lc code=start
class Solution {
  public int preimageSizeFZF(long K) {
    long l = K, r = 5 * K + 1;
    while (l < r) {
      long m = (l + r) >> 1;
      long count = zeta(m);
      if (count == K)
        return 5;
      else if (count < K)
        l = m + 1;
      else
        r = m - 1;
    }
    return 0;
  }

  public long zeta(long x) {
    if (x == 0)
      return 0;
    return x / 5 + zeta(x / 5);
  }
}
// @lc code=end
