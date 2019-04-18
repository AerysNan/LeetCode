import java.util.LinkedList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (36.45%)
 * Total Accepted:    2.9K
 * Total Submissions: 8K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
 * 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
 * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
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
