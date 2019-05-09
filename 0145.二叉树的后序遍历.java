import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */
class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode currentNode = root;
    while (currentNode != null || !stack.isEmpty()) {
      if (currentNode != null) {
        result.addFirst(currentNode.val);
        stack.push(currentNode);
        currentNode = currentNode.right;
      } else
        currentNode = stack.pop().left;
    }
    return result;
  }
}
