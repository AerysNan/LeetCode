/*
 * @lc app=leetcode.cn id=781 lang=java
 *
 * [781] 森林中的兔子
 */

// @lc code=start
class Solution {
  public int numRabbits(int[] answers) {
    int[] count = new int[1000];
    for (int answer : answers)
      count[answer]++;
    int result = 0;
    for (int i = 0; i < 1000; i++) {
      if (count[i] == 0)
        continue;
      result += ((count[i] - 1) / (i + 1) + 1) * (i + 1);
    }
    return result;
  }
}
// @lc code=end
