/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/*
 * // Definition for a Node. class Node { public int val; public List<Node> children;
 *
 * public Node() {}
 *
 * public Node(int _val) { val = _val; }
 *
 * public Node(int _val, List<Node> _children) { val = _val; children = _children; } };
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> levelOrder(Node root) {
    ArrayList<List<Integer>> result = new ArrayList<>();
    if (root == null)
      return result;
    LinkedList<Node> queue = new LinkedList<>();
    queue.addFirst(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      ArrayList<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        Node node = queue.pollLast();
        list.add(node.val);
        for (Node child : node.children)
          queue.addFirst(child);
      }
      result.add(list);
    }
    return result;
  }
}
// @lc code=end

