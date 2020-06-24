/*
 * @lc app=leetcode.cn id=649 lang=java
 *
 * [649] Dota2 参议院
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
    public String predictPartyVictory(String senate) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] people = new int[] { 0, 0 };
        int[] bans = new int[] { 0, 0 };
        for (char person : senate.toCharArray()) {
            int x = person == 'R' ? 1 : 0;
            people[x]++;
            queue.add(x);
        }
        while (people[0] > 0 && people[1] > 0) {
            int x = queue.poll();
            if (bans[x] > 0) {
                bans[x]--;
                people[x]--;
            } else {
                bans[x ^ 1]++;
                queue.add(x);
            }
        }
        return people[1] > 0 ? "Radiant" : "Dire";
    }
}
// @lc code=end
