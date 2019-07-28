/*
 * @lc app=leetcode.cn id=1128 lang=java
 *
 * [1128] 等价多米诺骨牌对的数量
 */
class Solution {
  public int numEquivDominoPairs(int[][] dominoes) {
    int[] count = new int[100];
    for (int[] domino : dominoes) {
      int a = Math.max(domino[0], domino[1]);
      int b = Math.min(domino[0], domino[1]);
      count[a * 10 + b]++;
    }
    int result = 0;
    for (int i = 0; i < 100; i++) {
      if (count[i] < 2)
        continue;
      result += count[i] * (count[i] - 1) / 2;
    }
    return result;
  }
}
