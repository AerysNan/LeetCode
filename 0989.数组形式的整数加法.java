/*
 * @lc app=leetcode.cn id=989 lang=java
 *
 * [989] 数组形式的整数加法
 */

// @lc code=start
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        int carry = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int value = A[i] + K % 10 + carry;
            list.addFirst(value % 10);
            carry = value / 10;
            K /= 10;
        }
        while (K > 0) {
            int value = K % 10 + carry;
            list.addFirst(value % 10);
            carry = value / 10;
            K /= 10;
        }
        if (carry > 0)
            list.addFirst(carry);
        return list;
    }
}
// @lc code=end
