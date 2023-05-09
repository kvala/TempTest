package test;

public class Q21_MergeTwoSorted {
    public ListNode mergeTwoListsMethodTwo(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode resHead = res;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

        if (l1 == null) {
            res.next = l2;
        } else if (l2 == null) {
            res.next = l1;
        }
        return resHead.next;
    }

    public static void main(String[] args) {
        Q21_MergeTwoSorted c = new Q21_MergeTwoSorted();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);

        ListNode n = c.mergeTwoListsMethodTwo(l1, l2);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}
