/*
 * @lc app=leetcode.cn id=475 lang=java
 *
 * [475] 供暖器
 */

// @lc code=start
class Solution {
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(heaters);
    int n = heaters.length, result = -1;
    for (int house : houses) {
      int distance = 0;
      if (house > heaters[n - 1])
        distance = house - heaters[n - 1];
      else {
        int l = 0, r = n - 1;
        while (l < r) {
          int mid = (l + r) >> 1;
          if (heaters[mid] < house)
            l = mid + 1;
          else
            r = mid;
        }
        distance = heaters[l] - house;
        if (l > 0)
          distance = Math.min(distance, house - heaters[l - 1]);
      }
      result = Math.max(result, distance);
    }
    return result;
  }
}
// @lc code=end

