/*
 * @lc app=leetcode.cn id=1095 lang=java
 *
 * [1095] 山脉数组中查找目标值
 */
/**
 * // This is MountainArray's API interface. // You should not implement it, or
 * speculate about its implementation interface MountainArray { public int
 * get(int index) {} public int length() {} }
 */

class Solution {
  int[] cache;
  MountainArray mountainArr;

  int getValue(int k) {
    if (cache[k] > 0)
      return cache[k];
    int value = mountainArr.get(k);
    cache[k] = value;
    return value;
  }

  int findPeek(int lo, int hi) {
    int mid = (lo + hi) / 2;
    int M = getValue(mid), L = getValue(mid - 1), R = getValue(mid + 1);
    if (M > L && M > R)
      return mid;
    if (M < L)
      return findPeek(lo, mid - 1);
    return findPeek(mid + 1, hi);
  }

  int binSearch(int target, int lo, int hi, boolean increase) {
    if (lo > hi)
      return -1;
    int mid = (lo + hi) / 2;
    int V = getValue(mid);
    if (V == target)
      return mid;
    if (increase && V < target || !increase && V > target)
      return binSearch(target, mid + 1, hi, increase);
    return binSearch(target, lo, mid - 1, increase);
  }

  public int findInMountainArray(int target, MountainArray mountainArr) {
    cache = new int[10000];
    for (int i = 0; i < 10000; i++)
      cache[i] = -1;
    this.mountainArr = mountainArr;
    int peek = findPeek(1, mountainArr.length() - 2);
    int index = binSearch(target, 0, peek, true);
    if (index >= 0)
      return index;
    return binSearch(target, peek + 1, mountainArr.length() - 1, false);
  }
}
