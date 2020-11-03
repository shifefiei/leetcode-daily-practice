import java.util.HashMap;
import java.util.Map;

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
public class PreOrder_Create_Tree {

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
    }

    private TreeNode buildTree(int[] preOrderArray, int[] inOrderArray) {
        int preLen = preOrderArray.length;
        int inLen = inOrderArray.length;

        //中根遍历 的树放到Map中,key=树的节点值，value=下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inOrderArray[i], i);
        }
        return this.createTree(preOrderArray, 0, preLen - 1, map, 0, inLen - 1);
    }

    private TreeNode createTree(int[] preOrderArray,
                                int preLeft, int preRight,
                                Map<Integer, Integer> map,
                                int inLeft, int inRight) {
        //设置递归结束条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        //构造二叉树的根节点
        int rootData = preOrderArray[preLeft];  //根节点的数值
        TreeNode root = new TreeNode(rootData);
        //获取 中根遍历 的根节点的下标
        int pIndex = map.get(rootData);

        root.left = this.createTree(preOrderArray,
                preLeft + 1, pIndex - inLeft + preLeft,
                map,
                inLeft, pIndex - 1);
        root.right = this.createTree(preOrderArray,
                pIndex - inLeft + preLeft + 1, preRight,
                map,
                pIndex + 1, inRight);

        return root;
    }

}


class TreeNode {
    int data;

    TreeNode left;

    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}