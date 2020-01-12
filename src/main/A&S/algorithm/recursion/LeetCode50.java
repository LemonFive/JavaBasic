package algorithm.recursion;

/**
 * @desc: 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 核心 递归+分治
 * @author: CuiShiHao
 **/
public class LeetCode50 {
    public static void main(String[] args) {
        double res = myPow(0.00001, 2147483647);
        System.out.println(res);
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }

        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return half * half * rest;
    }
}
