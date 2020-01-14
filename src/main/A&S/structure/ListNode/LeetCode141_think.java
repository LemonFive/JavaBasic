package ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc: 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * @author: CuiShiHao
 **/
public class LeetCode141_think {
    public static void main(String[] args) {
        ListNode head = ListNode.getListNode141_2();
        boolean result = hasCycle2(head);
        System.out.println(result);
    }

    // 解法一，利用Set校验是否重复
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    // 解法二，控制两个指针，利用步长进行判断。
    public static boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }

        }
        return false;
    }
}
