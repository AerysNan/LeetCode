/*
 * @lc app=leetcode.cn id=1371 lang=java
 *
 * [1371] 每个元音包含偶数次的最长子字符串
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  int findTheLongestSubstring(String s) {
    int[] prev = new int[32];
    Arrays.fill(prev, Integer.MAX_VALUE);
    int n = s.length(), state = 0, result = 0;
    prev[0] = -1;
    for (int i = 0; i < n; ++i) {
      switch (s.charAt(i)) {
        case 'a':
          state ^= 1;
          break;
        case 'e':
          state ^= 2;
          break;
        case 'i':
          state ^= 4;
          break;
        case 'o':
          state ^= 8;
          break;
        case 'u':
          state ^= 16;
          break;
        default:
          break;
      }
      if (prev[state] == Integer.MAX_VALUE)
        prev[state] = i;
      else
        result = Math.max(result, i - prev[state]);
    }
    return result;
  }
}
// @lc code=end

