import java.util.List;


/**
 * 后更遍历
 */
public class Post_Order_Tree {


    /**
     * 后续遍历二叉树
     */
    public void postOrder(TreeNode root, List<Integer> res) {

        if (null == root) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.data);
    }

}
