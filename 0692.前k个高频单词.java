/*
 * @lc app=leetcode.cn id=692 lang=java
 *
 * [692] 前K个高频单词
 */

// @lc code=start
import java.util.List;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.LinkedList;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words)
            count.put(word, count.getOrDefault(word, 0) + 1);
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1) == count.get(w2) ? w2.compareTo(w1) : count.get(w1) - count.get(w2));
        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k)
                heap.poll();
        }
        LinkedList<String> result = new LinkedList<>();
        while (!heap.isEmpty())
            result.addFirst(heap.poll());
        return result;
    }
}
// @lc code=end
