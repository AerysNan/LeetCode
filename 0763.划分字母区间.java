/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> partitionLabels(String S) {
    int[] last = new int[26];
    ArrayList<Integer> result = new ArrayList<>();
    char[] array = S.toCharArray();
    int n = array.length;
    for (int i = 0; i < n; i++)
      last[array[i] - 'a'] = i;
    int index = 0;
    while (index < n) {
      int l = index, r = index;
      index = last[array[r] - 'a'];
      while (index < n) {
        index = Math.max(index, last[array[r] - 'a']);
        if (index == r)
          break;
        r++;
      }
      result.add(r - l + 1);
      index++;
    }
    return result;
  }
}
// @lc code=end
