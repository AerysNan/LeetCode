/*
 * @lc app=leetcode.cn id=1361 lang=java
 *
 * [1361] 验证二叉树
 */

// @lc code=start
class Solution {
  int[] parents;

  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    parents = new int[n];
    for (int i = 0; i < n; i++)
      parents[i] = i;
    for (int i = 0; i < n; i++) {
      int l = leftChild[i];
      if (l != -1) {
        int pi = find(i), pl = find(l);
        if (pi == pl || pl != l)
          return false;
        parents[pl] = pi;
      }
      int r = rightChild[i];
      if (r != -1) {
        int pi = find(i), pr = find(r);
        if (pi == pr || pr != r)
          return false;
        parents[pr] = pi;
      }
    }
    int count = 0;
    for (int i = 0; i < n; i++)
      if (parents[i] == i)
        count++;
    return count == 1;
  }

  int find(int x) {
    while (parents[x] != x)
      x = parents[x];
    return x;
  }
}
// @lc code=end

