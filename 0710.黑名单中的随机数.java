/*
 * @lc app=leetcode.cn id=710 lang=java
 *
 * [710] 黑名单中的随机数
 */

// @lc code=start
import java.util.Arrays;
import java.util.Random;

class Solution {
    int n;
    int[] list;
    Random random;

    public Solution(int N, int[] blacklist) {
        n = N;
        Arrays.sort(blacklist);
        list = blacklist;
        random = new Random();
    }

    public int pick() {
        int k = random.nextInt(n - list.length);
        int l = 0, r = list.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (list[mid] - mid > k)
                r = mid - 1;
            else
                l = mid;
        }
        return l == r && list[l] - l <= k ? k + l + 1 : k;
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(N, blacklist); int param_1 = obj.pick();
 */
// @lc code=end
