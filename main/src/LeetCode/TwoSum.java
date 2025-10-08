package LeetCode;
import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int m = 0; m < nums.length; m++) {
                if (nums[i] + nums[m] == target && i != m) {
                    array[1] = i;
                    array[0] = m;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.print(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
