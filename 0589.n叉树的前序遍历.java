/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

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

    public List<Integer> preorder(Node root) {
        traverse(root);
        return result;
    }

    void traverse(Node node) {
        if (node == null)
            return;
        result.add(node.val);
        for (Node child : node.children)
            traverse(child);
    }
}
// @lc code=end
