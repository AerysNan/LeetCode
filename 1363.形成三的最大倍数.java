/*
 * @lc app=leetcode.cn id=1363 lang=java
 *
 * [1363] 形成三的最大倍数
 */

// @lc code=start
class Solution {
  int[] count = new int[10];

  public String largestMultipleOfThree(int[] digits) {
    int sum = 0;
    StringBuilder result = new StringBuilder();
    for (int d : digits) {
      count[d]++;
      sum += d;
    }
    if (sum % 3 == 1) {
      if (!remove(1)) {
        remove(2);
        remove(2);
      }
    } else if (sum % 3 == 2) {
      if (!remove(2)) {
        remove(1);
        remove(1);
      }
    }
    for (int i = 9; i >= 0; i--)
      while (count[i]-- > 0)
        result.append((char) (i + '0'));
    if (result.length() > 0 && result.charAt(0) == '0')
      return "0";
    return result.toString();
  }

  boolean remove(int value) {
    for (int i = value; i < 10; i += 3) {
      if (count[i] > 0) {
        count[i]--;
        return true;
      }
    }
    return false;
  }
}
// @lc code=end

