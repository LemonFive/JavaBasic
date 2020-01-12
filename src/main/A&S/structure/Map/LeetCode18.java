package Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc: 四数之和  核心哈希表
 * @author: CuiShiHao
 **/
public class LeetCode18 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 5, 0, 1, 5, 5, -4};
        int target = 11;
        List<List<Integer>> res = fourSum(nums, target);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return resultList;
        }

        Arrays.sort(nums);
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue; // 去重
            int value = nums[a];
            for (int i = a + 1; i < nums.length; i++) {
                if (i > a + 1 && nums[i] == nums[i - 1]) continue; // 去重
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum + value == target) {
                        resultList.add(Arrays.asList(nums[a], nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++; // 去重
                        while (left < right && nums[right] == nums[right - 1]) right--; // 去重
                        left++;
                        right--;
                    } else if (sum + value < target) {
                        left++;
                    } else if (sum + value > target) {
                        right--;
                    }
                }
            }
        }
        return resultList;
    }
}
