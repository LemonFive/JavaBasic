package Tree;

/**
 * @desc:
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @author: CuiShiHao
 **/
public class LeetCode98_think {

    public static void main(String[] args) {
        boolean res = isValidBST(TreeNode.getTreeNode1());
        System.out.println(res);
    }


    public static boolean isValidBST(TreeNode root) {
        return recursion(root, null, null);
    }

    private static boolean recursion(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        // 判断当前根结点是否满足要求
        if (min != null && root.val >= min) {
            return false;
        }
        if (max != null && root.val <= max) {
            return false;
        }

        // 判断当前结点的左右子树是否满足要求
        return recursion(root.left, root.val, max) && recursion(root.right, min, root.val);
    }
}
