package array;

import java.util.Arrays;

/**
 * 题目：非零元素移动
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * https://leetcode-cn.com/problems/move-zeroes/
 */

public class Move_Zeroes_Array {

    public static void main(String[] args) {
        int a[] = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZeroes(a)));
        System.out.println(Arrays.toString(moveZeroes2(a)));
    }

    /**
     * 创建两个指针i和j，第一次遍历的时候指针j用来记录当前有多少非0元素。
     * 即遍历的时候每遇到一个非0元素就将其往数组左边挪，第一次遍历完后，
     * j指针的下标就指向了最后一个非0元素下标。
     */
    public static int[] moveZeroes(int[] a) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                a[j++] = a[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < a.length; ++i) {
            a[i] = 0;
        }
        return a;
    }

    public static int[] moveZeroes2(int[] a) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                a[j] = a[i];
                if (j != i) {
                    a[i] = 0;
                }
                j++;
            }
        }
        return a;
    }

}
