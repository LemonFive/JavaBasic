package ListNode;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }


    /**
     * @description 单向链表 输入: 1->2->3->4->5->NULL
     * @author CuiShiHao
     * @date 2020/1/14
     */
    public static ListNode getListNode206() {
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(2);
        ListNode root3 = new ListNode(3);
        ListNode root4 = new ListNode(4);
        ListNode root5 = new ListNode(5);

        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root5;
        root5.next = null;

        return root1;
    }


    /**
     * @description 单向链表 输入: 1->4->3->2->5->2->NULL
     * @author CuiShiHao
     * @date 2020/1/14
     */
    public static ListNode getListNode86() {
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(7);
        ListNode root3 = new ListNode(5);
        ListNode root4 = new ListNode(1);
        ListNode root5 = new ListNode(9);
        ListNode root6 = new ListNode(2);
        ListNode root7 = new ListNode(5);
        ListNode root8 = new ListNode(1);

        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root5;
        root5.next = root6;
        root6.next = root7;
        root7.next = root8;

        return root1;
    }

    /**
     * @description 单向链表 输入: [9,7,6,7,6,9]
     * @author CuiShiHao
     * @date 2020/1/14
     */
    public static ListNode getListNode1019() {
        ListNode root1 = new ListNode(9);
        ListNode root2 = new ListNode(7);
        ListNode root3 = new ListNode(6);
        ListNode root4 = new ListNode(7);
        ListNode root5 = new ListNode(6);
        ListNode root6 = new ListNode(9);

        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root5;
        root5.next = root6;

        return root1;
    }

    /**
     * @description 环形链表
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * @author CuiShiHao
     * @date 2020/1/14
     */
    public static ListNode getListNode141() {
        ListNode root1 = new ListNode(3);
        ListNode root2 = new ListNode(2);
        ListNode root3 = new ListNode(0);
        ListNode root4 = new ListNode(-4);

        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root2;

        return root1;
    }

    public static ListNode getListNode141_2() {
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(2);
//        ListNode root3 = new ListNode(0);
//        ListNode root4 = new ListNode(-4);

        root1.next = root2;
        root2.next = null;
//        root3.next = root4;
//        root4.next = null;

        return root1;
    }
}



