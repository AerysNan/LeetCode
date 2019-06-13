import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1110 lang=java
 *
 * [1110] 删点成林
 */
class Solution {
  ArrayList<TreeNode> list;
  HashSet<Integer> set;
  TreeNode prev;

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    list = new ArrayList<>();
    set = new HashSet<>();
    prev = new TreeNode(-1);
    for (int value : to_delete)
      set.add(value);
    list.add(root);
    del(root);
    ArrayList<TreeNode> result = new ArrayList<>();
    for (TreeNode node : list)
      if (!set.contains(node.val))
        result.add(node);
    return result;
  }

  void del(TreeNode node) {
    if (node == null)
      return;
    TreeNode l = node.left;
    TreeNode r = node.right;
    if (set.contains(node.val)) {
      if (prev.left == node)
        prev.left = null;
      else
        prev.right = null;
      if (l != null) {
        node.left = null;
        list.add(l);
      }
      if (r != null) {
        node.right = null;
        list.add(r);
      }
    }
    TreeNode dump = prev;
    prev = node;
    del(l);
    del(r);
    prev = dump;
  }
}
