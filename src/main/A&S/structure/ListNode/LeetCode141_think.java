package ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc:
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
