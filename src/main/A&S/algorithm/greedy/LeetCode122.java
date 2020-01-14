package algorithm.greedy;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class LeetCode122 {
    public static void main(String[] args) {
        int[] prices ={3,2,6,5,0,3};
        int res = maxProfit(prices);
        System.out.println(res);
    }

    /**
     * @description  贪心算法求解
     * @author  CuiShiHao
     * @date    2020/1/13
     */
    public static int maxProfit(int[] prices) {
        int value = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int data = prices[i + 1] - prices[i];
            if (data > 0) {
                value = value + data;
            }
        }
        return value;
    }
}
