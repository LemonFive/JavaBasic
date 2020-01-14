package algorithm.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class LeetCode169 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int res = majorityElement3(nums);
    }

    /**
     * @description 利用Map计数  时间复杂度O(N)
     * @author CuiShiHao
     * @date 2020/1/13
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            Integer value = map.get(num);
            if (value == null) {
                map.put(num, 1);
            } else {
                map.put(num, ++value);
                if (value > nums.length / 2) {
                    return num;
                }
            }
        }
        return nums[0];
    }


    /**
     * @description sort排序法 时间复杂度O(NlogN)
     * @author CuiShiHao
     * @date 2020/1/13
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * @description 分治思想
     * @author CuiShiHao
     * @date 2020/1/13
     */
    public static int majorityElement3(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    public static int divide(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int middle = (end - start) / 2 + start;
        int left = divide(nums, start, middle);
        int right = divide(nums, middle + 1, end);

        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, start, end);
        int rightCount = countInRange(nums, left, start, end);
        return leftCount > rightCount ? left : right;
    }

    private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
