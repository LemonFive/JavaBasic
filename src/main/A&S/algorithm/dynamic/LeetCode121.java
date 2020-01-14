package algorithm.dynamic;

/**
 * @desc: 动态规划
 * @author: CuiShiHao
 **/
public class LeetCode121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(prices);
        System.out.println(res);
    }

    public static int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int value = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minValue > prices[i]) {
                minValue = prices[i];
            }
            if (prices[i] - minValue > value) {
                value = prices[i] - minValue;
            }
        }
        return value;
    }
}
