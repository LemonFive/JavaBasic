package algorithm.BFS;

import Tree.TreeNode;

/**
 * @desc: 111. 二叉树的最小深度
 * 核心：广度遍历
 * @author: CuiShiHao
 **/
public class LeetCode111 {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        DFS(root,1);
        return min;
    }

    private void DFS(TreeNode root, int level){
        if(root.left == null && root.right == null){
            if(min>level){
                min = level;
            }
        }
        if(root.left!=null && min>level){
            DFS(root.left,level+1);
        }
        if(root.right!=null && min>level){
            DFS(root.right,level+1);
        }
    }
}
