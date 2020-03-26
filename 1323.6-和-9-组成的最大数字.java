/*
 * @lc app=leetcode.cn id=1323 lang=java
 *
 * [1323] 6 和 9 组成的最大数字
 */

// @lc code=start
class Solution {
  public int maximum69Number(int num) {
    char[] array = String.valueOf(num).toCharArray();
    for (int i = 0; i < array.length; i++) {
      if (array[i] == '6') {
        array[i] = '9';
        break;
      }
    }
    return Integer.parseInt(new String(array));
  }
}
// @lc code=end

