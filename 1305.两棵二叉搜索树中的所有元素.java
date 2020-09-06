/*
 * @lc app=leetcode.cn id=1305 lang=java
 *
 * [1305] 两棵二叉搜索树中的所有元素
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeIterator implements Iterator<TreeNode> {
  Stack<TreeNode> stack;

  public TreeIterator(TreeNode root) {
    stack = new Stack<>();
    TreeNode node = root;
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  public TreeNode next() {
    TreeNode node = stack.pop(), next = node.right;
    while (next != null) {
      stack.push(next);
      next = next.left;
    }
    return node;
  }

  public TreeNode tryNext() {
    return stack.peek();
  }
}

class Solution {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    LinkedList<Integer> result = new LinkedList<>();
    TreeIterator iterator1 = new TreeIterator(root1), iterator2 = new TreeIterator(root2);
    while (iterator1.hasNext() && iterator2.hasNext()) {
      int value1 = iterator1.tryNext().val, value2 = iterator2.tryNext().val;
      if (value1 < value2) {
        result.add(value1);
        iterator1.next();
      } else {
        result.add(value2);
        iterator2.next();
      }
    }
    while (iterator1.hasNext())
      result.add(iterator1.next().val);
    while (iterator2.hasNext())
      result.add(iterator2.next().val);
    return result;
  }
}
// @lc code=end
