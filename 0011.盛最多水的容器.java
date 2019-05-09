/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */
class Solution {
  public int maxArea(int[] height) {
    int water = 0, l = 0, h = height.length - 1;
    while (l < h) {
      int length = Math.min(height[l], height[h]);
      water = Math.max(water, length * (h - l));
      while (l < h && height[l] <= length)
        l++;
      while (l < h && height[h] <= length)
        h--;
    }
    return water;
  }
}
