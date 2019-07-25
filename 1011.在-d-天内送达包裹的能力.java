/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */
class Solution {
  public int shipWithinDays(int[] weights, int D) {
    int sum = 0, max = -1;
    for (int w : weights) {
      sum += w;
      max = Math.max(max, w);
    }
    return search(weights, D, max, sum);
  }

  int search(int[] weights, int D, int l, int h) {
    if (l >= h)
      return l;
    int mid = (l + h) / 2;
    int sum = 0, count = 1;
    for (int i = 0; i < weights.length; i++) {
      if (sum + weights[i] > mid) {
        sum = 0;
        count++;
      }
      sum += weights[i];
    }
    if (count > D)
      return search(weights, D, mid + 1, h);
    return search(weights, D, l, mid);
  }
}
