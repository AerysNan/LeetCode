/*
 * @lc app=leetcode.cn id=682 lang=java
 *
 * [682] 棒球比赛
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
    public int calPoints(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();
        for (String op : ops) {
            if (op.equals("C"))
                list.pollLast();
            else if (op.equals("D"))
                list.addLast(2 * list.peekLast());
            else if (op.equals("+"))
                list.addLast(list.get(list.size() - 2) + list.peekLast());
            else
                list.add(Integer.parseInt(op));
        }
        return list.stream().mapToInt(x -> x).sum();
    }
}
// @lc code=end
