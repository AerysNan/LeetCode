/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N叉树的最大深度
 */

// @lc code=start

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
    public int maxDepth(Node root) {
        return root == null ? 0
                : (root.children == null ? 1
                        : root.children.stream().map(x -> maxDepth(x) + 1).reduce(1, (x, y) -> Math.max(x, y)));
    }
}
// @lc code=end
