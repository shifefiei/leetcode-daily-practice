package recursion;

/**
 * 递归打印字符串
 */
public class Print_String {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 4, 5, 6};
        printStr(0, nums);
    }

    private static void printStr(int index, int[] nums) {
        if (null == nums || index >= nums.length) {
            return;
        }

        printStr(index + 1, nums);
        System.out.println(nums[index]);
    }
}
