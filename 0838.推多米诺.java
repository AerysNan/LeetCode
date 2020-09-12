/*
 * @lc app=leetcode.cn id=838 lang=java
 *
 * [838] 推多米诺
 */

// @lc code=start

class Solution {
  public String pushDominoes(String dominos) {
    char[] array = dominos.toCharArray();
    int n = array.length, current = 0;
    int[] sum = new int[n];
    for (int i = 0; i < n; i++) {
      if (array[i] == 'R')
        current = n;
      else if (array[i] == 'L')
        current = 0;
      else
        current = Math.max(current - 1, 0);
      sum[i] += current;
    }
    current = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (array[i] == 'L')
        current = n;
      else if (array[i] == 'R')
        current = 0;
      else
        current = Math.max(current - 1, 0);
      sum[i] -= current;
    }
    for (int i = 0; i < n; i++)
      array[i] = sum[i] == 0 ? '.' : (sum[i] < 0 ? 'L' : 'R');
    return new String(array);
  }
}
// @lc code=end
