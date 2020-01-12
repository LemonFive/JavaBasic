package Queue;

import java.util.LinkedList;

/**
 * @desc: 核心: 使用双端队列
 * @author: CuiShiHao
 **/
public class LeetCode239 {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums, 3);
        System.out.println(res);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];

        // 创建一个Queue用来维护window,queue中存储的是数组位置。
        LinkedList<Integer> queue = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                res[i+1-k] = nums[queue.peek()];
            }
        }

        return res;
    }
}
