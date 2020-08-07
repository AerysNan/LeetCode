import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=762 lang=java
 *
 * [762] 二进制表示中质数个计算置位
 */

// @lc code=start
class Solution {
  public int countPrimeSetBits(int L, int R) {
    return (int) IntStream.rangeClosed(L, R).map(x -> Integer.bitCount(x)).filter(x -> isPrime(x)).count();
  }

  boolean isPrime(int x) {
    if (x == 1)
      return false;
    int n = (int) Math.sqrt(x);
    for (int i = 2; i <= n; i++)
      if (x % i == 0)
        return false;
    return true;
  }
}
// @lc code=end
