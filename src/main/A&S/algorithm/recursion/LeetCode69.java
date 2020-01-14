package algorithm.recursion;

/**
 * @desc: 二分法查找 递归
 * @author: CuiShiHao
 **/
public class LeetCode69 {
    public static void main(String[] args) {
        int res = mySqrt(4);
        System.out.println(res);
    }

    public static int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }

        int left = 1;
        int right = x;
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
