import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */
class Solution {
  public String removeDuplicates(String s) {
    char[] list = new char[s.length() + 1];
    list[0] = '^';
    int index = 1;
    for (int i = 0; i < s.length(); i++) {
      if (list[index - 1] == s.charAt(i))
        index--;
      else
        list[index++] = s.charAt(i);
    }
    String result = "";
    for (int i = 1; i < index; i++)
      result += list[i];
    return result;
  }
}
