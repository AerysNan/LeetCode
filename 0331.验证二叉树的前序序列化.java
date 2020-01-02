/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start
class Solution {
  public boolean isValidSerialization(String preorder) {
    String[] nodes = preorder.split(",");
    int diff = 1;
    for (String node : nodes) {
      if (--diff < 0)
        return false;
      if (!node.equals("#"))
        diff += 2;
    }
    return diff == 0;
  }
}
// @lc code=end

