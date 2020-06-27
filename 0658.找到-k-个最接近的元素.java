/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.sort((a, b) -> Math.abs(a - x) - Math.abs(b - x));
        List<Integer> result = list.subList(0, k);
        result.sort(Comparator.naturalOrder());
        return result;
    }
}
// @lc code=end
