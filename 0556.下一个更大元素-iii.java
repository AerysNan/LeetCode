/*
 * @lc app=leetcode.cn id=556 lang=java
 *
 * [556] 下一个更大元素 III
 */

// @lc code=start
class Solution {
    public int nextGreaterElement(int n) {
        char[] array = String.valueOf(n).toCharArray();
        int i = array.length - 2;
        while (i >= 0 && array[i + 1] <= array[i])
            i--;
        if (i < 0)
            return -1;
        int j = array.length - 1;
        while (j >= 0 && array[j] <= array[i])
            j--;
        char c = array[i];
        array[i] = array[j];
        array[j] = c;
        for (int l = i + 1, r = array.length - 1; l < r; l++, r--) {
            char _c = array[l];
            array[l] = array[r];
            array[r] = _c;
        }
        try {
            return Integer.parseInt(new String(array));
        } catch (Exception e) {
            return -1;
        }
    }
}
// @lc code=end
