/*
 * @lc app=leetcode.cn id=600 lang=java
 *
 * [600] 不含连续1的非负整数
 *
 * https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones/description/
 *
 * algorithms
 * Hard (24.62%)
 * Total Accepted:    408
 * Total Submissions: 1.7K
 * Testcase Example:  '1'
 *
 * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: 5
 * 解释:
 * 下面是带有相应二进制表示的非负整数<= 5：
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * 其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
 *
 * 说明: 1 <= n <= 10^9
 *
 */
class Solution {
  public int findIntegers(int num) {
    String string = String.valueOf(Integer.toBinaryString(num));
    int n = string.length();
    int[] headOne = new int[n];
    int[] headZero = new int[n];
    headOne[0] = 1;
    headZero[0] = 1;
    for (int i = 1; i < n; i++) {
      headZero[i] = headOne[i - 1] + headZero[i - 1];
      headOne[i] = headZero[i - 1];
    }
    int result = headOne[n - 1] + headZero[n - 1];
    System.out.println(result);
    for (int i = 1; i < n; i++) {
      if (string.charAt(i) == '1' && string.charAt(i - 1) == '1')
        break;
      if (string.charAt(i) == '0' && string.charAt(i - 1) == '0')
        result -= headOne[n - i - 1];
    }
    return result;
  }
}
