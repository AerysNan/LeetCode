/*
 * @lc app=leetcode.cn id=488 lang=java
 *
 * [488] 祖玛游戏
 */

// @lc code=start
import java.util.HashMap;
import java.util.TreeSet;

class Solution {
    int result;

    int[] getSame(StringBuilder board, int idx) {
        if (idx < 0 || idx >= board.length())
            return null;
        int left = idx;
        int right = idx;
        while (left > 0 && board.charAt(left - 1) == board.charAt(left))
            --left;
        while (right < board.length() - 1 && board.charAt(right + 1) == board.charAt(right))
            ++right;
        return new int[] { left, right };
    }

    void shoot(StringBuilder board, int idx) {
        int[] rg = getSame(board, idx);
        if (rg == null)
            return;
        if (rg[1] - rg[0] + 1 < 3)
            return;
        String s = board.substring(0, rg[0]) + board.substring(rg[1] + 1);
        board.delete(0, board.length()).append(s);
        shoot(board, Math.max(rg[0] - 1, 0));
    }

    void find(StringBuilder board, HashMap<Character, Integer> cntHand, int step) {
        if (step >= result)
            return;
        if (board.length() == 0) {
            result = Math.min(result, step);
            return;
        }

        for (int i = 0; i < board.length(); i++) {
            if (i != 0 && board.charAt(i) == board.charAt(i - 1))
                continue;
            TreeSet<String> insertList = new TreeSet<>();
            int[] rg = getSame(board, i);
            if (rg != null && rg[1] - rg[0] == 0)
                insertList.add(new StringBuilder().append(board.charAt(i)).append(board.charAt(i)).toString());
            else {
                insertList.add(new StringBuilder().append(board.charAt(i)).toString());
                int[] flag = new int[2];
                char c = board.charAt(i);
                for (int d = 0; d <= 1; d++) {
                    int td = d * 2 - 1;
                    for (int j = i; j >= 0 && j < board.length(); j += td) {
                        if (td == 1 && j == 0)
                            continue;
                        if (td == -1 && j == board.length() - 1)
                            continue;
                        flag[d] += (board.charAt(j - td) == c && board.charAt(j) != c) ? 1 : 0;
                        flag[d] += (board.charAt(j - td) != c && board.charAt(j) == c) ? 1 : 0;
                        if (flag[d] <= 2)
                            continue;
                        insertList.add(new StringBuilder().append(board.charAt(j)).toString());
                    }
                }
            }
            for (String item : insertList) {
                char c = item.charAt(0);
                if (cntHand.getOrDefault(c, 0) < item.length())
                    continue;
                cntHand.put(c, cntHand.get(c) - item.length());
                StringBuilder newBoard = new StringBuilder(board).insert(i + 1, item);
                shoot(newBoard, i);
                find(newBoard, cntHand, step + item.length());
                cntHand.put(c, cntHand.get(c) + item.length());
            }
        }
    }

    int findMinStep(String board, String hand) {
        HashMap<Character, Integer> cntBoard = new HashMap<>(), cntHand = new HashMap<>();
        for (char c : board.toCharArray())
            cntBoard.put(c, cntBoard.getOrDefault(c, 0) + 1);
        for (char c : hand.toCharArray())
            cntHand.put(c, cntHand.getOrDefault(c, 0) + 1);
        for (char c : cntBoard.keySet())
            if (cntBoard.getOrDefault(c, 0) < 3 && cntHand.getOrDefault(c, 0) + cntBoard.getOrDefault(c, 0) < 3)
                return -1;
        result = Integer.MAX_VALUE;
        find(new StringBuilder(board), cntHand, 0);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}
// @lc code=end
