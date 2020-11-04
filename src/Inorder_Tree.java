import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 中根遍历
 */
public class Inorder_Tree {
    public static void main(String[] args) {

        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */
        //前序遍历
        int[] preOrderArray = new int[]{3, 9, 20, 15, 7};
        //中序遍历
        int[] inOrderArray = new int[]{9, 3, 15, 20, 7};

        TreeNode root = new PreOrder_Create_Tree().buildTree(preOrderArray, inOrderArray);

        List<Integer> orderList = new Inorder_Tree().inOrder(root);
        for (Integer integer : orderList) {
            System.out.print(integer + " , ");
        }

        System.out.println("\n--------------------不同的遍历方式-------------------------");

        //非递归实现中根遍历
        List<Integer> orderStack = new Inorder_Tree().inOrderStack(root);
        for (Integer integer : orderStack) {
            System.out.print(integer + " , ");
        }
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderTree(root, res);
        return res;
    }

    /**
     * 递归遍历二叉树
     */
    private void inOrderTree(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        inOrderTree(root.left, res);
        res.add(root.data);
        inOrderTree(root.right, res);
    }

    /**
     * 非递归方式遍历
     * 1.先将左子树的左子树 全部压入栈
     * 2.往外弹出栈
     */
    private List<Integer> inOrderStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (null != root || !stack.isEmpty()) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.data);
            root = root.right;
        }
        return res;
    }
}

