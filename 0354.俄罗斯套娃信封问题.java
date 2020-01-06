/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes.length == 0)
      return 0;
    Arrays.sort(envelopes, new Comparator<int[]>() {
      public int compare(int[] arr1, int[] arr2) {
        int value = Integer.compare(arr1[0], arr2[0]);
        if (value == 0)
          return Integer.compare(arr2[1], arr1[1]);
        return value;
      }
    });
    int dp[] = new int[envelopes.length], result = 0;
    for (int[] envelope : envelopes) {
      int index = Arrays.binarySearch(dp, 0, result, envelope[1]);
      if (index < 0)
        index = -(index + 1);
      dp[index] = envelope[1];
      if (index == result)
        result++;
    }
    return result;
  }
}
// @lc code=end

