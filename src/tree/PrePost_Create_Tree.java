package tree;

import java.util.Arrays;

/**
 * 根据前序和后序遍历构造二叉树
 * 示例：
 * <p>
 * 输入：pre = [1,2,4,5,3,6,7],post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * <p>
 * 前序遍历：pre=[1] + [2,4,5] + [3,6,7]
 * 后序遍历：post=[4,5,2] + [6,7,5] + [1]
 * 如何划左右子树范围？只有划分了范围才能进行递归？
 * <p>
 * 前序遍历左子树：[2,4,5]
 * 后序遍历左子树：[4,5,2]
 * 我们令左分支有 L 个节点。则左分支的头节点为 pre[1]，但它也出现在左分支的后序表示的最后。所以 pre[1] = post[L-1] ，因此 L = post.indexOf(pre[1]) + 1。
 * <p>
 * 前序左分支范围：pre[ 1 : L + 1]
 * 后序左分支范围：post[ 0 : L ]
 * <p>
 * len 表示整个树的节点个数
 * 前序右分支范围：pre[ L+1 : len]
 * 后序右分支范围：post[ L : len -1 ]
 */
public class PrePost_Create_Tree {


    public TreeNode createTree(int[] pre, int[] post) {
        int len = pre.length;
        if (len == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        if (len == 1) {
            return root;
        }

        //求出左分支树的节点个数,遍历左分支树，求左子树的全部节点个数
        int leftNodeCount = 0;
        for (int i = 0; i < len; ++i) {
            if (post[i] == pre[1]) {
                leftNodeCount = i + 1;
                break;
            }
        }

        //然后分别递归左子树、右子树
        root.left = createTree(Arrays.copyOfRange(pre, 1, leftNodeCount + 1),
                Arrays.copyOfRange(post, 0, len));

        root.right = createTree(Arrays.copyOfRange(pre, leftNodeCount + 1, len),
                Arrays.copyOfRange(post, leftNodeCount, len - 1));
        return root;
    }

}
