/*
 * @lc app=leetcode.cn id=558 lang=java
 *
 * [558] 四叉树交集
 */

// @lc code=start
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf)
            return new Node(quadTree1.val || quadTree2.val, true, null, null, null, null);
        if (quadTree1.isLeaf)
            return quadTree1.val ? quadTree1 : quadTree2;
        if (quadTree2.isLeaf)
            return quadTree2.val ? quadTree2 : quadTree1;
        Node TL = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node TR = intersect(quadTree1.topRight, quadTree2.topRight);
        Node BL = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node BR = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (TL.isLeaf && TR.isLeaf && BL.isLeaf && BR.isLeaf && TL.val == TR.val && TR.val == BL.val
                && BL.val == BR.val)
            return new Node(TL.val, true, null, null, null, null);
        return new Node(false, false, TL, TR, BL, BR);
    }
}
// @lc code=end
