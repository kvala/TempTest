package test;

public class Q19_nthElement {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            //handle bad inputs such that n number of nodes are not there. 
            if(fast == null){
                return null;
            }
            
            fast = fast.next;
          
        }

        //if remove the first node
        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args){
        Q19_nthElement c = new Q19_nthElement();
        ListNode input = new ListNode(1);
        System.out.println(c.removeNthFromEnd(input, 5));
    }
}
