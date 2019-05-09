/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */
class Solution {
  public int trap(int[] height) {
    int result = 0;
    int maxIndex = -1, maxHeight = -1, length = height.length;
    if (length <= 1)
      return 0;
    for (int i = 0; i < length; i++) {
      if (height[i] > maxHeight) {
        maxHeight = height[i];
        maxIndex = i;
      }
    }
    int leftHeight = height[0];
    for (int i = 1; i < maxIndex; i++) {
      if (height[i] > leftHeight)
        leftHeight = height[i];
      else
        result += leftHeight - height[i];
    }
    int rightHeight = height[length - 1];
    for (int i = length - 1; i > maxIndex; i--) {
      if (height[i] > rightHeight)
        rightHeight = height[i];
      else
        result += rightHeight - height[i];
    }
    return result;
  }
}
