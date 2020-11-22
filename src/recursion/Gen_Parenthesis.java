package recursion;

import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 * <p>
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Gen_Parenthesis {

    public static void main(String[] args) {

        new Gen_Parenthesis().genParenthesis(3);

    }

    public List<String> genParenthesis(int n) {

        //gen(0, 2 * n, "");

        create(0,0,3,"");
        return null;
    }

    /**
     * @param level ((())) 代表下标
     * @param max   ((())) 最大长度，这里即 6
     * @param s     生成的括号形式
     */
    private void gen(int level, int max, String s) {
        if (level > max) {
            System.out.println(s);
            return;
        }

        String s1 = s + "(";
        String s2 = s + ")";

        gen(level + 1, max, s1);
        gen(level + 1, max, s2);

    }


    /**
     * @param left  左括号个数，最大3
     * @param right 右括号个数，最大3
     * @param n     括号最大个数
     * @param s     保存最后生成的括号
     */
    private void create(int left, int right, int n, String s) {
        //表示左括号、右括号都用完了
        if (left == n && right == n) {
            System.out.println(s);
            return;
        }

        //字符串要合法，左括号一定不能用完
        if (left < n) {
            create(left + 1, right, n, s + "(");
        }

        //字符串要合法，左括号的个数一定是大于右括号的个数
        if (left > right) {
            create(left, right + 1, n, s + ")");

        }
    }

}
