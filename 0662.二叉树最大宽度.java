/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.LinkedList;

class AnnotatedNode {
  TreeNode node;
  int depth, pos;

  AnnotatedNode(TreeNode n, int d, int p) {
    node = n;
    depth = d;
    pos = p;
  }
}


class Solution {
  public int widthOfBinaryTree(TreeNode root) {
    LinkedList<AnnotatedNode> queue = new LinkedList<>();
    queue.add(new AnnotatedNode(root, 0, 0));
    int depth = 0, left = 0, result = 0;
    while (!queue.isEmpty()) {
      AnnotatedNode node = queue.poll();
      if (node.node != null) {
        queue.add(new AnnotatedNode(node.node.left, node.depth + 1, node.pos * 2));
        queue.add(new AnnotatedNode(node.node.right, node.depth + 1, node.pos * 2 + 1));
        if (depth != node.depth) {
          depth = node.depth;
          left = node.pos;
        }
        result = Math.max(result, node.pos - left + 1);
      }
    }
    return result;
  }
}
// @lc code=end

