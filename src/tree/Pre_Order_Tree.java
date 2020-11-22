package tree;

import java.util.*;

/**
 * 前序遍历二叉树
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * <p>
 * 最牛题解：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
 */
public class Pre_Order_Tree {
    /**
     * 非递归前序遍历
     * <p>
     * 我们优先将头结点加入Stack，然后打印。
     * 之后我们应该先打印左子树，然后右子树。所以先加入Stack的就是右子树，然后左子树。
     */
    public List<Integer> preOrderStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                result.add(root.data);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }


    /**
     * 递归前序遍历
     */
    public List<Integer> preOrder(TreeNode root, List<Integer> res) {

        if (null == root) {
            return res;
        }
        res.add(root.data);
        preOrder(root.left, res);
        preOrder(root.right, res);
        return res;
    }


    /**
     * 前序遍历、中序遍历 构造二叉树
     * 思路：只要我们在 中序遍历 中定位到根节点，那么我们就可以分别知道 左子树 和 右子树 中的节点数目
     * <p>
     * 前序遍历：  【 根 】      【左 *************** 子 *************** 树】       【右 *************** 子 *************** 树】
     * *********** preLeft      preLeft+1                             x         y=x+1                                 preRight
     * 中序遍历：  【左 *************** 子 *************** 树】         【 根 】    【右 *************** 子 *************** 树】
     * *********** inLeft                               pIndex-1     pIndex     pIndex+1                           inRight
     * <p>
     * 求 x 的值，x=  - (preLeft + 1) = pIndex-1 - inLeft   => x = pIndex - inLeft + preLeft
     * 则 y = x + 1 = pIndex - inLeft + preLeft + 1
     */

    //前序遍历
    int[] preOrderArray = new int[]{3, 9, 20, 15, 7};
    //中序遍历
    int[] inOrderArray = new int[]{9, 3, 15, 20, 7};

    public TreeNode createTree(int[] preArray, int[] inArray) {
        int preLen = preArray.length;
        int inLen = preArray.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inArray[i], i);
        }
        return this.create(preArray, 0, preLen - 1, map, 0, inLen - 1);
    }

    private TreeNode create(int[] preArray, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {

        Integer rootData = preArray[preLeft];
        int pIndex = map.get(rootData);

        TreeNode root = new TreeNode(rootData);

        root.left = this.create(preOrderArray,
                preLeft + 1, pIndex - inLeft + preLeft,
                map,
                inLeft, pIndex - 1);

        root.right = this.create(preOrderArray,
                pIndex - inLeft + preLeft + 1, preRight,
                map,
                pIndex + 1, inRight);
        return root;
    }
}
