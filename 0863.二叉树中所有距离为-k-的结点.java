/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Solution {
  HashMap<Integer, ArrayList<Integer>> graph;

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    graph = new HashMap<>();
    traverse(root);
    HashSet<Integer> visited = new HashSet<>();
    visited.add(target.val);
    LinkedList<Integer> queue = new LinkedList<>();
    queue.offer(target.val);
    for (int i = 0; i < K; i++) {
      int size = queue.size();
      for (int j = 0; j < size; j++) {
        int current = queue.poll();
        if (!graph.containsKey(current))
          continue;
        for (int next : graph.get(current)) {
          if (visited.contains(next))
            continue;
          visited.add(next);
          queue.offer(next);
        }
      }
    }
    return queue;
  }

  void traverse(TreeNode node) {
    if (node.left != null) {
      graph.computeIfAbsent(node.val, x -> new ArrayList<>()).add(node.left.val);
      graph.computeIfAbsent(node.left.val, x -> new ArrayList<>()).add(node.val);
      traverse(node.left);
    }
    if (node.right != null) {
      graph.computeIfAbsent(node.val, x -> new ArrayList<>()).add(node.right.val);
      graph.computeIfAbsent(node.right.val, x -> new ArrayList<>()).add(node.val);
      traverse(node.right);
    }
  }
}
// @lc code=end
