package algorithm.BFS;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class LeetCode102 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNodeLeetCode102();
        List<List<Integer>> resList = levelOrder2(treeNode);
        System.out.println(resList);
    }

    //非递归解法
    public static List<List<Integer>> levelOrder1(TreeNode root) {

        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            resList.add(list);
        }
        return resList;
    }


    private static List<List<Integer>> lists = new ArrayList<>();

    //递归解法
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        DFS(root, 0);
        return lists;
    }

    public static void DFS(TreeNode root, int level) {

        //当前层数还没有元素，先new一个空的列表
        if (lists.size() <= level) {
            lists.add(new ArrayList<>());
        }
        //当前值加入
        lists.get(level).add(root.val);

        if (root.left != null) {
            DFS(root.left, level + 1);
        }
        if (root.right != null) {
            DFS(root.right, level + 1);
        }
    }
}
