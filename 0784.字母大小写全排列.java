/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;

class Solution {
  ArrayList<String> result;

  public List<String> letterCasePermutation(String S) {
    result = new ArrayList<>();
    search(new StringBuilder(), S.toCharArray(), 0);
    return result;
  }

  void search(StringBuilder current, char[] array, int index) {
    if (index == array.length) {
      result.add(current.toString());
      return;
    }
    if (array[index] >= '0' && array[index] <= '9')
      search(current.append(array[index]), array, index + 1);
    else {
      search(new StringBuilder(current).append(Character.toLowerCase(array[index])), array, index + 1);
      search(new StringBuilder(current).append(Character.toUpperCase(array[index])), array, index + 1);
    }
  }
}
// @lc code=end
