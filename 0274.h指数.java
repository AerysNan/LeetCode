import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H指数
 */
class Solution {
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int n = citations.length;
    for (int i = n - 1; i >= 0; i--) {
      int citation = citations[i];
      if (citation < n - i)
        return n - i - 1;
    }
    return n;
  }
}
