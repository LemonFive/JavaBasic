package Tree;

/**
 * @desc:
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @author: CuiShiHao
 **/
public class LeetCode98 {

    public static void main(String[] args) {
        boolean res = isValidBST(getTreeNode1());
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


    /**
     * @param
     * @return
     * @description 输入:
     * 2
     * / \
     * 1   3
     * 输出: true
     * @author CuiShiHao
     * @date 2020/1/12
     */
    private static TreeNode getTreeNode1() {
        TreeNode root2 = new TreeNode(2);
        TreeNode root1 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        root2.left = root1;
        root2.right = root3;
        return root2;
    }


    /**
     * @return
     * @description 输入:
     * 5
     * / \
     * 1   4
     * / \
     * 3   6
     * 输出: false
     * @author CuiShiHao
     * @date 2020/1/12
     */
    private static TreeNode getTreeNode2() {
        TreeNode root5 = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root4 = new TreeNode(4);
        TreeNode root3 = new TreeNode(3);
        TreeNode root6 = new TreeNode(6);
        root5.left = root1;
        root5.right = root4;
        root4.left = root3;
        root4.right = root6;
        return root5;
    }
}
