/*
 * @lc app=leetcode.cn id=990 lang=java
 *
 * [990] 等式方程的可满足性
 */

// @lc code=start
class Solution {
    int[] ufs;

    int find(int x) {
        while (ufs[x] != x)
            x = ufs[x];
        return x;
    }

    void union(int x, int y) {
        int parentX = find(x), parentY = find(y);
        if (parentX != parentY)
            ufs[parentX] = parentY;
    }

    public boolean equationsPossible(String[] equations) {
        ufs = new int[26];
        for (int i = 0; i < 26; i++)
            ufs[i] = i;
        for (String equation : equations)
            if (equation.charAt(1) == '=')
                union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
        for (String equation : equations)
            if (equation.charAt(1) == '!' && find(equation.charAt(0) - 'a') == find(equation.charAt(3) - 'a'))
                return false;
        return true;
    }
}
// @lc code=end
