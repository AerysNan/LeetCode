/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */
public class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int result = 0;
    while (n != 0) {
      result += n & 1;
      n >>>= 1;
    }
    return result;
  }
}
