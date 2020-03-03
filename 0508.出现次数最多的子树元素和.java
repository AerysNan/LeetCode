/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
  HashMap<Integer, Integer> map = new HashMap<>();
  int max = 0;

  public int[] findFrequentTreeSum(TreeNode root) {
    traverse(root);
    ArrayList<Integer> list = new ArrayList<>();
    for (Entry<Integer, Integer> e : map.entrySet())
      if (e.getValue().equals(max))
        list.add(e.getKey());
    return list.stream().mapToInt(i -> i).toArray();
  }

  int traverse(TreeNode node) {
    if (node == null)
      return 0;
    int l = traverse(node.left), r = traverse(node.right);
    int sum = l + r + node.val, count = map.getOrDefault(sum, 0) + 1;
    max = Math.max(max, count);
    map.put(sum, count);
    return sum;
  }
}
// @lc code=end

