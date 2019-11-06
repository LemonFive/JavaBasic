import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class Solution {

    public static void main(String[] args) {

        int[] nums = {1,2,0,3,12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                if(i != j){
                    nums[i] = nums[j];
                }
                i ++;
            }
        }
        for(; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}

