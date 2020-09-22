/*
 * @lc app=leetcode.cn id=1593 lang=java
 *
 * [1593] 拆分字符串使唯一子字符串的数目最大
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  public int maxUniqueSplit(String s) {
    int n = s.length();
    char[] array = s.toCharArray();
    int count = 1 << (n - 1), result = 1;
    for (int i = count - 1; i >= 1; i--)
      if (valid(array, i))
        result = Math.max(result, Integer.bitCount(i) + 1);
    return result;
  }

  boolean valid(char[] array, int split) {
    String s = new String(array);
    ArrayList<Integer> indices = new ArrayList<>();
    for (int i = 0; i < array.length - 1; i++)
      if ((split & (1 << i)) > 0)
        indices.add(i);
    HashSet<String> set = new HashSet<>();
    int prev = 0;
    for (int index : indices) {
      String str = s.substring(prev, index + 1);
      if (!set.add(str))
        return false;
      prev = index + 1;
    }
    String str = s.substring(indices.get(indices.size() - 1) + 1);
    if (!set.add(str))
      return false;
    return true;
  }
}

// @lc code=end
