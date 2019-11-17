/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.LinkedList;

class BSTIterator {
  LinkedList<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new LinkedList<>();
    TreeNode current = root;
    while (current != null) {
      stack.addLast(current);
      current = current.left;
    }
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = stack.pollLast();
    TreeNode current = node.right;
    while (current != null) {
      stack.addLast(current);
      current = current.left;
    }
    return node.val;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator obj = new
 * BSTIterator(root); int param_1 = obj.next(); boolean param_2 = obj.hasNext();
 */
// @lc code=end

