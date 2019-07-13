/*
 * @lc app=leetcode.cn id=1028 lang=java
 *
 * [1028] 从先序遍历还原二叉树
 */
class TreeNode {
  TreeNode left;
  TreeNode right;
  int val;

  public TreeNode(int val) {
    this.val = val;
  }
}

class Solution {
  String s;
  int pointer;

  public TreeNode recoverFromPreorder(String S) {
    this.s = S;
    return buildTree(0, s.length(), 1);
  }

  TreeNode buildTree(int begin, int end, int depth) {
    if (begin >= end || begin >= s.length())
      return null;
    int value = getValue(begin);
    TreeNode node = new TreeNode(value);
    if (pointer == end)
      return node;
    int index1 = getIndex(pointer, end, depth);
    int index2 = getIndex(index1 + depth, end, depth);
    node.left = buildTree(index1 + depth, index2, depth + 1);
    node.right = buildTree(index2 + depth, end, depth + 1);
    return node;
  }

  int getValue(int index) {
    int result = 0;
    this.pointer = index;
    while (pointer < s.length() && isDigit(s.charAt(pointer)))
      result = result * 10 + s.charAt(pointer++) - '0';
    return result;
  }

  int getIndex(int begin, int end, int depth) {
    for (int i = begin; i < end - depth + 1; i++) {
      if (i > 0 && s.charAt(i - 1) == '-')
        continue;
      boolean match = true;
      for (int j = 0; j < depth; j++) {
        if (s.charAt(i + j) != '-') {
          match = false;
          break;
        }
      }
      if (match && i + depth < end && isDigit(s.charAt(i + depth)))
        return i;
    }
    return end;
  }

  boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }
}
