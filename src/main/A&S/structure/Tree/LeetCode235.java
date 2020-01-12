package Tree;

/**
 * 二叉搜索树
 * @desc: 根结点比两个结点都大 就在左子树找
 * 根结点比两个结点都小 就在右子树找
 * @author: CuiShiHao
 **/
public class LeetCode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
