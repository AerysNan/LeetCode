/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    ArrayList<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        traverse(root);
        return result;
    }

    void traverse(Node node) {
        if (node == null)
            return;
        for (Node child : node.children)
            traverse(child);
        result.add(node.val);
    }
}
// @lc code=end
