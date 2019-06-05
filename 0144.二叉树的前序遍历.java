import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<>();
    LinkedList<TreeNode> s = new LinkedList<>();
    TreeNode node = root;
    while (!s.isEmpty() || node != null) {
      while (node != null) {
        list.add(node.val);
        s.addLast(node);
        node = node.left;
      }
      if (!s.isEmpty())
        node = s.pollLast().right;
    }
    return list;
  }
}
