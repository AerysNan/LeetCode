/*
 * @lc app=leetcode.cn id=703 lang=java
 *
 * [703] 数据流中的第K大元素
 */

// @lc code=start
import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> head, tail;
    int k;

    public KthLargest(int k, int[] nums) {
        head = new PriorityQueue<>();
        tail = new PriorityQueue<>((x, y) -> y - x);
        this.k = k;
        for (int num : nums) {
            head.add(num);
            if (head.size() > k)
                tail.add(head.poll());
        }
    }

    public int add(int val) {
        head.add(val);
        if (head.size() > k)
            tail.add(head.poll());
        return head.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */
// @lc code=end
