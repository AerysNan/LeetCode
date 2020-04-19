import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
/*
 * @lc app=leetcode.cn id=1307 lang=java
 *
 * [1307] 口算难题
 */

// @lc code=start
class Solution {
  boolean search(HashMap<Character, Integer> map, LinkedList<Character> stack,
      HashSet<Character> set, boolean[] used, int sum) {
    if (stack.isEmpty())
      return sum == 0;
    char c = stack.pop();
    for (int i = 0; i < 10; i++) {
      if (used[i])
        continue;
      if (i == 0 && set.contains(c))
        continue;
      used[i] = true;
      sum += map.get(c) * i;
      if (search(map, stack, set, used, sum))
        return true;
      sum -= map.get(c) * i;
      used[i] = false;
    }
    stack.push(c);
    return false;
  }

  public boolean isSolvable(String[] words, String result) {
    HashMap<Character, Integer> map = new HashMap<>();
    HashSet<Character> set = new HashSet<>();
    for (String word : words) {
      char[] array = word.toCharArray();
      set.add(array[0]);
      for (int i = 0; i < array.length; i++) {
        char c = array[i];
        map.put(c, map.getOrDefault(c, 0) + (int) Math.pow(10, array.length - 1 - i));
      }
    }
    char[] array = result.toCharArray();
    set.add(array[0]);
    for (int i = 0; i < array.length; i++) {
      char c = array[i];
      map.put(c, map.getOrDefault(c, 0) - (int) Math.pow(10, array.length - 1 - i));
    }
    LinkedList<Character> stack = new LinkedList<>(map.keySet());
    return search(map, stack, set, new boolean[10], 0);
  }
}
// @lc code=end
