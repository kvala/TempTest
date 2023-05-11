package test;

public class Q24_Kgroup {
    // 1->2->3->4->5
    // 0->1->2->3->4->5
    // p->c
    // 3
    // 3->2->1->4->5->6
    // p = 3
    // c = 4

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode helper = new ListNode(0);
        helper.next = head;

        ListNode pre = helper;
        ListNode cur = head;

        int counter = 0;

        while (cur != null) {
            counter++;

            if (counter % k == 0) {
                pre = reverseRange(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }

        return helper.next;
    }

    // Reverse the linked list from pre to end, exclusively
    private ListNode reverseRange(ListNode prev, ListNode end) {
        ListNode head = prev.next;
        ListNode curr = head.next;

        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev.next;
            prev.next = curr;

            curr = temp;
        }

        head.next = end;
        return head;
    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Q24_Kgroup c = new Q24_Kgroup();

        ListNode r = c.reverseKGroup(l1, 3);
        while(r!= null){
            System.out.print(r.val + "->");
            r = r.next;
        }
    }

}
