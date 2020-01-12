package Tree;

/**
 * 二叉树
 * @desc: 根结点比两个结点都大 就在左子树找
 * 根结点比两个结点都小 就在右子树找
 * @author: CuiShiHao
 **/
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p ||root ==q) return root;
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        if(right==null){
            return left;
        }
        if(left==null){
            return right;
        }
        return root;
    }
}
