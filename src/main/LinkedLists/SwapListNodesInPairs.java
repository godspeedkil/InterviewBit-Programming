package LinkedLists;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapListNodesInPairs {

    /**
     * If it's a matter of simple pair swapping, it's way simpler to simply
     * swap values between pairs, instead of messing with pointers. Still O
     * (n) either way.
     */
    public static ListNode swapPairs(ListNode A) {
        ListNode current = A;

        while (current!=null && current.next!=null) {
            int temp = current.val;
            current.val = current.next.val;
            current.next.val = temp;
            current = current.next.next;
        }

        return A;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        System.out.println(swapPairs(head1));
        ListNode head2 = new ListNode(1);
        System.out.println(swapPairs(head2));
    }
}
