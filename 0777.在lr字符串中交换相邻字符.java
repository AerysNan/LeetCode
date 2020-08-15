/*
 * @lc app=leetcode.cn id=777 lang=java
 *
 * [777] 在LR字符串中交换相邻字符
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
  public boolean canTransform(String start, String end) {
    if (!start.replace("X", "").equals(end.replace("X", "")))
      return false;
    LinkedList<Integer> listL = new LinkedList<>(), listR = new LinkedList<>();
    char[] arrayStart = start.toCharArray(), arrayEnd = end.toCharArray();
    for (int i = 0; i < arrayStart.length; i++) {
      if (arrayStart[i] == 'L')
        listL.addFirst(i);
      else if (arrayStart[i] == 'R')
        listR.addFirst(i);
    }
    for (int i = 0; i < arrayEnd.length; i++)
      if (arrayEnd[i] == 'L' && i > listL.pollLast() || arrayEnd[i] == 'R' && i < listR.pollLast())
        return false;
    return true;
  }
}
// @lc code=end
