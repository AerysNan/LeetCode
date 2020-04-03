/*
 * @lc app=leetcode.cn id=1177 lang=java
 *
 * [1177] 构建回文串检测
 */

// @lc code=start
class Solution {
  public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
    int n = s.length();
    int[][] count = new int[n][26];
    count[0][s.charAt(0) - 'a']++;
    for (int i = 1; i < n; ++i) {
      count[i][s.charAt(i) - 'a']++;
      for (int j = 0; j < 26; ++j)
        count[i][j] += count[i - 1][j];
    }
    ArrayList<Boolean> result = new ArrayList<>();
    for (int[] query : queries) {
      int left = query[0], right = query[1], k = query[2];
      if (k >= right - left + 1) {
        result.add(true);
        continue;
      }
      int modify = 0;
      for (int i = 0; i < 26; i++) {
        int num = left == 0 ? count[right][i] : count[right][i] - count[left - 1][i];
        if (num % 2 == 1)
          modify++;
      }
      result.add(modify / 2 <= k);
    }
    return result;
  }
}
// @lc code=end

