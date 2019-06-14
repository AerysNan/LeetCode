/*
 * @lc app=leetcode.cn id=1111 lang=java
 *
 * [1111] 有效括号的嵌套深度
 */
class Solution {
  public int[] maxDepthAfterSplit(String seq) {
    int n = seq.length(), res[] = new int[n];
    for (int i = 0; i < n; ++i)
      res[i] = seq.charAt(i) == '(' ? i & 1 : (1 - i & 1);
    return res;
  }
}
