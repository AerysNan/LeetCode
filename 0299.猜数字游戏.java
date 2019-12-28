/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
  public String getHint(String secret, String guess) {
    int n = secret.length(), bull = 0, cow = 0;
    int[] map1 = new int[10], map2 = new int[10];
    for (int i = 0; i < n; i++) {
      char c1 = secret.charAt(i), c2 = guess.charAt(i);
      if (c1 == c2) {
        bull++;
        continue;
      }
      map1[c1 - '0']++;
      map2[c2 - '0']++;
    }
    for (int i = 0; i < 10; i++)
      cow += Math.min(map1[i], map2[i]);
    return bull + "A" + cow + "B";
  }
}
// @lc code=end

