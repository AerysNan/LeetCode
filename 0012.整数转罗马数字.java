/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */
class Solution {
  public String intToRoman(int num) {
    int[] nums = new int[4];
    StringBuilder result = new StringBuilder();
    char[][] map = new char[][] { { 'I', 'V' }, { 'X', 'L' }, { 'C', 'D' }, { 'M', '\0' } };
    for (int i = 0; i < 4; i++) {
      nums[i] = num % 10;
      num /= 10;
    }
    for (int i = 0; i < nums[3]; i++)
      result.append('M');
    for (int i = 2; i >= 0; i--) {
      if (nums[i] == 4)
        result.append(map[i][0]).append(map[i][1]);
      else if (nums[i] == 9)
        result.append(map[i][0]).append(map[i + 1][0]);
      else if (nums[i] >= 5) {
        result.append(map[i][1]);
        for (int j = 0; j < nums[i] - 5; j++)
          result.append(map[i][0]);
      } else
        for (int j = 0; j < nums[i]; j++)
          result.append(map[i][0]);
    }
    return result.toString();
  }
}
