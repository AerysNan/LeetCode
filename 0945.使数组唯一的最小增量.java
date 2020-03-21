/*
 * @lc app=leetcode.cn id=945 lang=java
 *
 * [945] 使数组唯一的最小增量
 */

// @lc code=start
class Solution {
  public int minIncrementForUnique(int[] A) {
    int[] map = new int[80000];
    for (int a : A)
      map[a]++;
    int result = 0, count = 0;
    for (int i = 0; i < 80000; i++) {
      if (map[i] >= 2) {
        count += map[i] - 1;
        result -= i * (map[i] - 1);
      } else if (count > 0 && map[i] == 0) {
        count--;
        result += i;
      }
    }
    return result;
  }
}
// @lc code=end

