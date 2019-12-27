/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.Optional;
import javafx.util.Pair;

class Solution {
  public int kthSmallest(TreeNode root, int k) {
    return search(root, k).getKey().get();
  }

  Pair<Optional<Integer>, Optional<Integer>> search(TreeNode node, int k) {
    if (node == null)
      return new Pair<>(Optional.empty(), Optional.of(0));
    Pair<Optional<Integer>, Optional<Integer>> p = search(node.left, k);
    if (p.getKey().isPresent())
      return p;
    int size = p.getValue().get();
    if (size + 1 == k)
      return new Pair<>(Optional.of(node.val), Optional.empty());
    p = search(node.right, k - size - 1);
    if (p.getKey().isPresent())
      return p;
    return new Pair<>(Optional.empty(), Optional.of(p.getValue().get() + size + 1));
  }
}
// @lc code=end

