package Queue;

import java.util.LinkedList;

/**
 * @desc: 核心: 使用双端队列
 * @author: CuiShiHao
 **/
public class LeetCode239_think {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow(nums, 3);
        System.out.println(res);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];

        // queue中存储数组下标
        LinkedList<Integer> queue = new LinkedList();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!queue.isEmpty() && nums[queue.peekLast()] < num) {
                queue.pollLast();
            }
            queue.add(i);

            // 判断是否超过窗口范围，超过范围则推出队首
            if (queue.peek() <= i - k) {
                queue.poll();
            }

            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peek()];
            }
        }
        return res;
    }
}
