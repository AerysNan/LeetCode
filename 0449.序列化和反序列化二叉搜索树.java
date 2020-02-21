/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null)
      return "# ";
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(root.val).append(' ');
    return stringBuilder.append(serialize(root.left)).append(serialize(root.right)).toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] nodes = data.split(" ");
    return run(nodes, new int[] {0});
  }

  TreeNode run(String[] nodes, int[] index) {
    int pos = index[0];
    if (nodes[pos].equals("#")) {
      index[0]++;
      return null;
    }
    TreeNode node = new TreeNode(Integer.parseInt(nodes[pos]));
    index[0]++;
    node.left = run(nodes, index);
    node.right = run(nodes, index);
    return node;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

