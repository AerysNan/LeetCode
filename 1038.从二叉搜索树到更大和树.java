import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1038 lang=java
 *
 * [1038] 从二叉搜索树到更大和树
 */
class Solution {
  LinkedList<TreeNode> list = new LinkedList<>();

  public TreeNode bstToGst(TreeNode root) {
    traverse(root);
    int value = 0;
    while (!list.isEmpty()) {
      TreeNode node = list.pollLast();
      value += node.val;
      node.val = value;
    }
    return root;
  }

  void traverse(TreeNode node) {
    if (node == null)
      return;
    traverse(node.left);
    list.addLast(node);
    traverse(node.right);
  }
}
