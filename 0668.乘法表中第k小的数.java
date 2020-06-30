/*
 * @lc app=leetcode.cn id=668 lang=java
 *
 * [668] 乘法表中第k小的数
 */

// @lc code=start
class Solution {
    public int findKthNumber(int m, int n, int k) {
        if (k == 1)
            return 1;
        if (k == m * n)
            return m * n;
        int l = 1, r = m * n;
        while (l < r) {
            int mid = (l + r) >> 1;
            int temp = count(m, n, mid);
            if (temp < k)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    int count(int m, int n, int value) {
        int result = 0;
        for (int i = 1; i <= m; i++)
            result += Math.min(value / i, n);
        return result;
    }
}
// @lc code=end
