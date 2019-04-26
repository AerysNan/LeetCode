/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 *
 * https://leetcode-cn.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (51.02%)
 * Total Accepted:    2.4K
 * Total Submissions: 4.6K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 * 1
 * /
 * 3
 * \
 * 2
 *
 * 输出: [3,1,null,null,2]
 *
 * 3
 * /
 * 1
 * \
 * 2
 *
 *
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 *
 * 输出: [2,1,4,null,null,3]
 *
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 *
 * 进阶:
 *
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 *
 *
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {
  private TreeNode current;
  private TreeNode prev;
  private TreeNode tmp;
  private TreeNode n1, n2;

  public void recoverTree(TreeNode root) {
    current = root;
    while (current != null) {
      if (current.left == null) {
        check();
        current = current.right;
      } else {
        tmp = current.left;
        while (tmp.right != null && tmp.right != current)
          tmp = tmp.right;
        if (tmp.right == null) {
          tmp.right = current;
          current = current.left;
        } else if (tmp.right == current) {
          tmp.right = null;
          check();
          current = current.right;
        }
      }
    }
    int tmp = n1.val;
    n1.val = n2.val;
    n2.val = tmp;
  }

  private void check() {
    if (prev != null && prev.val > current.val) {
      if (n1 == null)
        n1 = prev;
      n2 = current;
    }
    tmp = current;
    prev = current;
  }
}
