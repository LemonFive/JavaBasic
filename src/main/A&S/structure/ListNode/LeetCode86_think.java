package ListNode;

/**
 * @desc: 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * @author: CuiShiHao
 **/
public class LeetCode86_think {
    public static void main(String[] args) {
        ListNode head = ListNode.getListNode86();
        ListNode res = partition(head, 3);
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode more = new ListNode(-1);
        ListNode moreHead = more;
        ListNode less = new ListNode(-1);
        ListNode lessHead = less;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            }
            if (head.val >= x) {
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }

        // 避免出现环
        more.next = null;
        less.next = moreHead.next;

        return lessHead.next;
    }
}
