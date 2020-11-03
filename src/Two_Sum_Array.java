import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：两数之和
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class Two_Sum_Array {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int item = target - nums[i];
            if (map.containsKey(item)) {
                return new int[]{i, map.get(item)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
