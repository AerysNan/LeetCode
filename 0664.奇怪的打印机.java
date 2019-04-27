/*
 * @lc app=leetcode.cn id=664 lang=java
 *
 * [664] 奇怪的打印机
 *
 * https://leetcode-cn.com/problems/strange-printer/description/
 *
 * algorithms
 * Hard (29.59%)
 * Total Accepted:    212
 * Total Submissions: 715
 * Testcase Example:  '"aaabbb"'
 *
 * 有台奇怪的打印机有以下两个特殊要求：
 *
 *
 * 打印机每次只能打印同一个字符序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 *
 *
 * 给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。
 *
 * 示例 1:
 *
 *
 * 输入: "aaabbb"
 * 输出: 2
 * 解释: 首先打印 "aaa" 然后打印 "bbb"。
 *
 *
 * 示例 2:
 *
 *
 * 输入: "aba"
 * 输出: 2
 * 解释: 首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 *
 * 提示: 输入字符串的长度不会超过 100。
 *
 */
class Solution {
  private int[][] dp;

  private int search(int l, int h, String s) {
    if (dp[l][h] > 0)
      return dp[l][h];
    dp[l][h] = h - l + 1;
    for (int k = l; k < h; k++)
      dp[l][h] = Math.min(dp[l][h], search(l, k, s) + search(k + 1, h, s));
    if (s.charAt(l) == s.charAt(h))
      dp[l][h]--;
    return dp[l][h];
  }

  public int strangePrinter(String s) {
    int n = s.length();
    if (n == 0)
      return 0;
    dp = new int[n][n];
    for (int i = 0; i < n; i++)
      dp[i][i] = 1;
    return search(0, n - 1, s);
  }
}
