package algorithm.BFS;

import Tree.TreeNode;

/**
 * @desc: 104. 二叉树的最大深度
 * @author: CuiShiHao
 **/
public class LeetCode104 {
    int resLevel = 0;
    public int maxDepth(TreeNode root) {
        if(root==null){
            return resLevel;
        }

        DFS(root,resLevel);
        return resLevel +1;
    }

    private void DFS(TreeNode root,int level){
        if (level > resLevel){
            resLevel = level;
        }
        if (root.left != null) {
            DFS(root.left, level + 1);
        }
        if (root.right != null) {
            DFS(root.right, level + 1);
        }
    }
}
