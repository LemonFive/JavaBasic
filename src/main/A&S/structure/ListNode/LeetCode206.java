package ListNode;

import ListNode.ListNode;

/**
 * @desc: 206、反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author: CuiShiHao
 **/
public class LeetCode206 {
    public static void main(String[] args) {
        ListNode head = ListNode.getListNode206();
        ListNode res = reverseList(head);
    }

    /**
     * @description 解法时间复杂度 O(n)
     * @author CuiShiHao
     * @date 2020/1/14
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = null;
        while (head != null) {
            ListNode node = head.next;
            head.next = res;
            res = head;
            head = node;
        }
        return res;
    }
}
