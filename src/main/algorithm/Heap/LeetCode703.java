package Heap;

import java.util.PriorityQueue;

/**
 * @desc: 核心：PriorityQueue【小顶堆输出最小值】
 * @author: CuiShiHao
 **/
public class LeetCode703 {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {7, 11, 8, 2, 9, 10, 19};

        int result = LargestElementStream(k, nums);
        System.out.println(result);
    }

    private static int size;
    private static PriorityQueue<Integer> q;

    public static int LargestElementStream(int k, int[] nums) {
        size = k;
        q = new PriorityQueue(k);
        for (int num : nums) {
            add(num);
        }
        return add(Integer.MAX_VALUE);
    }

    public static int add(int val) {
        if (q.size() < size) {
            q.add(val);
        } else if (q.peek() < val) {
            q.poll();
            q.add(val);
        }
        return q.peek();
    }
}



class KthLargest {
    private PriorityQueue<Integer> q;
    private int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        q = new PriorityQueue(size);

        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        if(q.size()<size){
            q.add(val);
        }
        else{
            // 判断插入值是否大于顶端值
            if(q.peek()<val){
                q.add(val);
                q.poll();
            }
        }
        return q.peek();
    }
}
