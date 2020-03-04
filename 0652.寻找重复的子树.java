
/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
  int id = 1;
  HashMap<String, Integer> trees = new HashMap<>();
  HashMap<Integer, Integer> count = new HashMap<>();
  ArrayList<TreeNode> result = new ArrayList<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    traverse(root);
    return result;
  }

  public int traverse(TreeNode node) {
    if (node == null)
      return 0;
    String serial = node.val + "," + traverse(node.left) + "," + traverse(node.right);
    int uid = trees.computeIfAbsent(serial, x -> id++);
    count.put(uid, count.getOrDefault(uid, 0) + 1);
    if (count.get(uid) == 2)
      result.add(node);
    return uid;
  }
}
// @lc code=end

