package LinkedLists;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 *
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {

    /**
     * O(n) solution based on the Nth node from the end principal. That is to
     * say, rotating B times makes it so the Nth element from the end ends up
     * as the new head of the list. Finding out the size and the last
     * element, we can easily find out at which points to modify pointers.
     */
    public static ListNode rotateRight(ListNode A, int B) {
        ListNode last = A;
        int size = 0;

        while (last.next != null) {
            last = last.next;
            size++;
        }
        size++;

        B %= size; // This is crucial for those sneaky edge cases where B>= size

        ListNode temp = A;
        for (int i=1; i<size-B; i++) {
            temp = temp.next;
        }

        last.next = A;
        A = temp.next;
        temp.next = null;

        return A;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println(rotateRight(head1, 2));
    }
}
