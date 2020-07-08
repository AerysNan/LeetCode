/*
 * @lc app=leetcode.cn id=690 lang=java
 *
 * [690] 员工的重要性
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int n = employees.stream().mapToInt(e -> e.id).max().getAsInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (Employee e : employees) {
            adj.get(e.id).addAll(e.subordinates);
            map.put(e.id, e.importance);
        }
        int result = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(id);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            result += map.get(index);
            for (int next : adj.get(index))
                queue.add(next);
        }
        return result;
    }
}
// @lc code=end
