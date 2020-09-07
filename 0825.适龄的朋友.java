/*
 * @lc app=leetcode.cn id=825 lang=java
 *
 * [825] 适龄的朋友
 */

// @lc code=start
class Solution {
  public int numFriendRequests(int[] ages) {
    int[] count = new int[121];
    for (int age : ages)
      count[age]++;
    int result = 0;
    for (int i = 0; i <= 120; i++) {
      if (count[i] == 0)
        continue;
      if (i > 14)
        result += count[i] * (count[i] - 1);
      for (int j = 0; j < i; j++)
        if (j > (i >>> 1) + 7)
          result += count[i] * count[j];
    }
    return result;
  }
}
// @lc code=end
