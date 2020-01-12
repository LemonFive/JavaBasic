package Map;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 两数之和  核心哈希表
 * @author: CuiShiHao
 **/
public class LeetCode1 {

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int[] res = twoSum(nums, 6);
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap(nums.length);
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
