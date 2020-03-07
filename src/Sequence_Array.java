package com.sff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shifeifei on 2020/3/6.
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * <p>
 * 限制：
 * 1 <= target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 */
public class Sequence_Array {

    public static void main(String[] args) {
        int[][] list = findContinuousSequence(9);
        System.out.println(Arrays.deepToString(list));
    }

    public static int[][] findContinuousSequence(int target) {

        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和

        List<int[]> result = new ArrayList<>();
        // 滑动窗口的左边界不能超过target的中值
        while (i <= target / 2) {

            if (sum < target) { //向左移动，加大窗口
                sum += j;
                j++;
            } else if (sum > target) { // 向右移动，减小窗口
                sum -= i;
                i++;
            } else {
                //相等就把指针形成的窗口添加进输出列表中
                int[] array = new int[j-i];
                for (int k = i; k < j; k++) {
                    array[k-i] = k;
                }
                result.add(array);
                // 上面已经找到了一组连续的序列，还要继续找下一组，次数左边界向右移动
                sum -= i;
                i++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
