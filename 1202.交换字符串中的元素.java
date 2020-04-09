/*
 * @lc app=leetcode.cn id=1202 lang=java
 *
 * [1202] 交换字符串中的元素
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Solution {
  int[] prev;

  int find(int x) {
    int root = x;
    while (root != prev[root])
      root = prev[root];
    while (x != root) {
      int temp = prev[x];
      prev[x] = root;
      x = temp;
    }
    return root;
  }

  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    int n = s.length();
    prev = IntStream.range(0, n).toArray();
    for (List<Integer> pair : pairs)
      prev[find(pair.get(0))] = find(pair.get(1));
    ArrayList<PriorityQueue<Character>> list = new ArrayList<>();
    for (int i = 0; i < n; i++)
      list.add(new PriorityQueue<>());
    for (int i = 0; i < n; i++)
      list.get(find(i)).add(s.charAt(i));
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < n; i++)
      result.append(list.get(find(i)).poll());
    return result.toString();
  }
}
// @lc code=end

