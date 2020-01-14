package ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @desc: 1019. 链表中的下一个更大节点
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 * <p>
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 * <p>
 * 示例 1：
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * <p>
 * 示例 2：
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * <p>
 * 示例 3：
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *  
 * <p>
 * 提示：
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 * @author: CuiShiHao
 * 个人理解，遇到需要先后顺序需要后进先出的结构使用Stack！！！
 **/
public class LeetCode1019_think {
    public static void main(String[] args) {
        ListNode head = ListNode.getListNode1019();  //[9,7,6,7,6,9]
        int[] result = nextLargerNodes(head);

        System.out.println(result);
    }

    public static int[] nextLargerNodes(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        reduce(head, stack, res);
        int[] array = new int[res.size()];
        for (int j = res.size() - 1; j >= 0; j--)
            array[res.size() - 1 - j] = res.get(j);
        return array;
    }

    private static void reduce(ListNode head, LinkedList<Integer> stack, ArrayList<Integer> res) {
        if (head == null) {
            return;
        }
        reduce(head.next, stack, res);
        while (!stack.isEmpty() && stack.peekFirst() <= head.val) {
            stack.pop();
        }
        res.add(stack.isEmpty() ? 0 : stack.peekFirst());
        stack.push(head.val);
    }
}
