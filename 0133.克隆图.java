/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
 * // Definition for a Node. class Node { public int val; public List<Node> neighbors;
 *
 * public Node() {}
 *
 * public Node(int _val,List<Node> _neighbors) { val = _val; neighbors = _neighbors; } };
 */
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
  HashMap<Integer, Node> map;

  public Node cloneGraph(Node node) {
    map = new HashMap<>();
    return clone(node);
  }

  Node clone(Node node) {
    if (map.containsKey(node.val))
      return map.get(node.val);
    Node c = new Node();
    c.neighbors = new ArrayList<>();
    c.val = node.val;
    map.put(c.val, c);
    for (Node n : node.neighbors)
      c.neighbors.add(clone(n));
    return c;
  }
}
// @lc code=end

