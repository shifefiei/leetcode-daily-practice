package array;

/**
 * 题目：删除排序数组中的重复项
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */
public class Remove_Duplicates_Array {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        int i = 0; //标识最终数组长度
        for (int j = 1; j < num.length; j++) {
            if (num[j] != num[i]) {
                i++;
                num[i] = num[j];
            }
        }
        return i + 1;
    }
}
