import java.util.LinkedList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */
class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int x) {
    val = x;
  }
}

public class Codec {

  private static String EmptyNotation = "#";
  private static String SplitNotation = ",";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder builder = new StringBuilder();
    TreeToString(root, builder);
    return builder.toString();
  }

  private void TreeToString(TreeNode node, StringBuilder builder) {
    if (node == null) {
      builder.append(EmptyNotation);
      builder.append(SplitNotation);
      return;
    }
    builder.append(node.val);
    builder.append(SplitNotation);
    TreeToString(node.left, builder);
    TreeToString(node.right, builder);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    LinkedList<String> list = new LinkedList<>();
    list.addAll(Arrays.asList(data.split(SplitNotation)));
    return StringToTree(list);
  }

  private TreeNode StringToTree(LinkedList<String> list) {
    String s = list.removeFirst();
    if (s.equals(EmptyNotation))
      return null;
    TreeNode node = new TreeNode(Integer.valueOf(s));
    node.left = StringToTree(list);
    node.right = StringToTree(list);
    return node;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
