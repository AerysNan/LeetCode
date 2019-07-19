import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1003 lang=java
 *
 * [1003] 检查替换后的词是否有效
 */
class Solution {
  public boolean isValid(String S) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < S.length(); i++) {
      int value = S.charAt(i) - 'a';
      if (value == 2 && list.size() >= 2) {
        int last1 = list.pollLast();
        int last2 = list.peekLast();
        if (last1 == 1 && last2 == 0)
          list.pollLast();
        else {
          list.addLast(last1);
          list.addLast(value);
        }
      } else
        list.addLast(value);
    }
    return list.isEmpty();
  }
}
