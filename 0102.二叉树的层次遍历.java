import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 */
class Solution {
  private List<List<Integer>> result;
  private Queue<TreeNode> queue;

  public List<List<Integer>> levelOrder(TreeNode root) {
    result = new ArrayList<>();
    queue = new LinkedList<>();
    if (root == null)
      return result;
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currentList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        currentList.add(node.val);
        if (node.left != null)
          queue.add(node.left);
        if (node.right != null)
          queue.add(node.right);
      }
      result.add(currentList);
    }
    return result;
  }
}
