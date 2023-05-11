package test;

public class Q23_MergeKSort {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        return MergeSort(lists, 0, lists.length - 1);

    }

    public ListNode MergeSort(ListNode[] lists, int start, int end) {
        if (start == end) {
            //System.out.println(lists[start].val);
            return lists[start];
        }

        int mid = start + (end - start) / 2;

        ListNode l1 = MergeSort(lists, start, mid);
        ListNode l2 = MergeSort(lists, mid + 1, end);

        return MergeTwoLists(l1, l2);
    }

    public ListNode MergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if (l1 != null) {
            dummy.next = l1;
        }

        if (l2 != null) {
            dummy.next = l2;
        }

        return res.next;
    }

    public static void main(String[] args){
        Q23_MergeKSort c = new Q23_MergeKSort();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(9);

        ListNode[] input = {l1, l2, l3, l4};
        ListNode res = c.mergeKLists(input);
        while(res!= null){
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}
