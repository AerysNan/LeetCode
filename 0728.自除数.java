/*
 * @lc app=leetcode.cn id=728 lang=java
 *
 * [728] 自除数
 */

// @lc code=start
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        return IntStream.rangeClosed(left, right).filter(x -> valid(x)).boxed().collect(Collectors.toList());
    }

    public boolean valid(int n) {
        for (char c : String.valueOf(n).toCharArray())
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        return true;
    }
}
// @lc code=end
