package ListNode;

import ListNode.ListNode;

/**
 * @desc: 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @author: CuiShiHao
 **/
public class LeetCode24 {

    public static void main(String[] args) {
        ListNode head = ListNode.getListNode206();
        ListNode res = swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 每次仅交换两个节点，剩余节点递归调用
        ListNode node = head.next;
        ListNode otherNode = swapPairs(node.next);
        node.next = null;
        head.next = otherNode;
        node.next = head;

        return node;
    }
}
