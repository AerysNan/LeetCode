/*
 * @lc app=leetcode.cn id=458 lang=java
 *
 * [458] 可怜的小猪
 */
class Solution {
  public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    int testCount = minutesToTest / minutesToDie + 1;
    for (int i = 0;; i++)
      if (Math.pow(testCount, i) >= buckets)
        return i;
  }
}
