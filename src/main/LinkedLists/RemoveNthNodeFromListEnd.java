package LinkedLists;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 *  Note:
 * If n is greater than the size of the list, remove the first node of the list.
 * Try doing it using constant additional space.
 */
public class RemoveNthNodeFromListEnd {

    /**
     * O(n) solution seems to be the best. First we get the size of the list,
     * then we figure out the nth node from the end by simple subtraction. We
     * position ourselves before the node we want to remove, and we simply
     * skip it.
     */
    public static ListNode removeNthFromEnd(ListNode A, int B) {
        int size = 0;
        ListNode temp = A;

        while (temp!=null) {
            size++;
            temp = temp.next;
        }

        if (B>=size) {
            return A.next;
        }

        temp = A;
        for (int i=1; i<size-B; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return A;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(head1, 2));
    }
}
