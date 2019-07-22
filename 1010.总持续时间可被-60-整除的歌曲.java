/*
 * @lc app=leetcode.cn id=1010 lang=java
 *
 * [1010] 总持续时间可被 60 整除的歌曲
 */
class Solution {
  public int numPairsDivisibleBy60(int[] time) {
    int[] count = new int[60];
    for (int t : time)
      count[t % 60]++;
    int result = 0;
    for (int i = 1; i < 30; i++)
      result += count[i] * count[60 - i];
    result += count[0] == 0 ? 0 : (count[0] * (count[0] - 1) / 2);
    result += count[30] == 0 ? 0 : (count[30] * (count[30] - 1) / 2);
    return result;
  }
}
