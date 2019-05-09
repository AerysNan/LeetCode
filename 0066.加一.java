import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */
class Solution {
  public int[] plusOne(int[] digits) {
    digits[digits.length - 1]++;
    LinkedList<Integer> array = new LinkedList<>();
    int carry = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      array.addFirst((carry + digits[i]) % 10);
      carry = (carry + digits[i]) / 10;
    }
    if (carry != 0)
      array.addFirst(carry);
    int[] result = new int[array.size()];
    for (int i = 0; i < array.size(); i++)
      result[i] = array.get(i);
    return result;
  }
}
