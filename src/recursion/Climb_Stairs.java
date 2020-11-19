package recursion;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 爬楼梯问题
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？( n 是一个整数)
 * <p>
 * 示例1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * (1)  1 阶 + 1 阶
 * (2)  2 阶
 * <p>
 * 示例2:
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * (1)  1 阶 + 1 阶 + 1 阶
 * (2)  1 阶 + 2 阶
 * (3)  2 阶 + 1 阶
 * <p>
 * 思路：
 * 爬到第 xx 级台阶的方案数是爬到第 x - 1x−1 级台阶的方案数和爬到第 x - 2x−2 级台阶的方案数的和
 * f(1)=1
 * f(2)=2
 * f(3)=3
 * f(4)=5
 * <p>
 * f(x) = f(x-1)+f(x-2)
 */
public class Climb_Stairs {

    public static void main(String[] args) {

        Climb_Stairs climb_stairs = new Climb_Stairs();
        System.out.println(climb_stairs.violenceRecursive(4));

    }

    /**
     * 暴力递归
     */
    private int violenceRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return violenceRecursive(n - 1) + violenceRecursive(n - 2);
    }

    /**
     * 动态规划解决
     */



}
