package Tree;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
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
    public static TreeNode getTreeNode1() {
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
    public static TreeNode getTreeNode2() {
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


    /**
     * @return
     * @description 输入:
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 输出: false
     * @author CuiShiHao
     * @date 2020/1/12
     */
    public static TreeNode getTreeNodeLeetCode102() {
        TreeNode root3 = new TreeNode(3);
        TreeNode root9 = new TreeNode(9);
        TreeNode root20 = new TreeNode(20);
        TreeNode root15 = new TreeNode(15);
        TreeNode root7 = new TreeNode(7);
        root3.left = root9;
        root3.right = root20;
        root20.left = root15;
        root20.right = root7;
        return root3;
    }
}
