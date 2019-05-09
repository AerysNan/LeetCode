/*
 * @lc app=leetcode.cn id=397 lang=java
 *
 * [397] 整数替换
 */
class Solution {
  public int integerReplacement(int n) {
    int count = 0;
    while (true) {
      if (n == 1)
        return count;
      if ((n & 1) == 0)
        n >>>= 1;
      else if (n == 3 || (n & 3) == 1)
        n -= 1;
      else
        n += 1;
      count++;
    }
  }
}
