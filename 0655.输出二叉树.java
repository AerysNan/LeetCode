import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=655 lang=java
 *
 * [655] 输出二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public List<List<String>> printTree(TreeNode root) {
    int height = getHeight(root);
    String[][] array = new String[height][(1 << height) - 1];
    for (String[] arr : array)
      Arrays.fill(arr, "");
    List<List<String>> result = new ArrayList<>();
    fill(array, root, 0, 0, array[0].length);
    for (String[] arr : array)
      result.add(Arrays.asList(arr));
    return result;
  }

  public void fill(String[][] result, TreeNode node, int i, int l, int r) {
    if (node == null)
      return;
    result[i][(l + r) / 2] = String.valueOf(node.val);
    fill(result, node.left, i + 1, l, (l + r - 1) / 2);
    fill(result, node.right, i + 1, (l + r + 1) / 2, r);
  }

  public int getHeight(TreeNode root) {
    if (root == null)
      return 0;
    return 1 + Math.max(getHeight(root.left), getHeight(root.right));
  }
}
// @lc code=end

